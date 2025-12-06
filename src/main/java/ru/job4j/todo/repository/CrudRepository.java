package ru.job4j.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@AllArgsConstructor
@Repository
@Slf4j
public class CrudRepository {

    private final SessionFactory sessionFactory;

    public void run(Consumer<Session> command) {
        tx(session -> {
            command.accept(session);
            return null;
        });
    }

    public int run(String query, Map<String, Object> args) {
        return tx(session -> {
            var sq = session.createQuery(query);
            for (var entry : args.entrySet()) {
                sq.setParameter(entry.getKey(), entry.getValue());
            }
            return sq.executeUpdate();
        });
    }

    public <T> Optional<T> optional(String query, Class<T> cl, Map<String, Object> args) {
        Function<Session, Optional<T>> command = session -> {
            var sq = session.createQuery(query, cl);
            for (Map.Entry<String, Object> entry : args.entrySet()) {
                sq.setParameter(entry.getKey(), entry.getValue());
            }
            return sq.uniqueResultOptional();
        };
        return tx(command);
    }

    public <T> List<T> query(String query, Class<T> cl) {
        Function<Session, List<T>> command = session ->
            session.createQuery(query, cl).list();
        return tx(command);
    }

    public <T> List<T> query(String query, Class<T> cl, Map<String, Object> args) {
        Function<Session, List<T>> command = session -> {
          var sq = session.createQuery(query, cl);
          for (Map.Entry<String, Object> entry : args.entrySet()) {
              sq.setParameter(entry.getKey(), entry.getValue());
          }
          return sq.list();
        };
        return tx(command);
    }

    public <T> T tx(Function<Session, T> command) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("error during transaction execution", e);
            throw e;
        }
    }
}
