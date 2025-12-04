package ru.job4j.todo.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.User;

import java.util.Optional;

@Repository
@Slf4j
public class HblUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    public HblUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> create(User user) {
        Session session = sessionFactory.openSession();
        Optional<User> result = Optional.empty();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            result = Optional.of(user);
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Some error during saving new User happened", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        try (Session session = sessionFactory.openSession()) {
           return Optional.ofNullable(session.createQuery("FROM User u WHERE u.login = :login AND u.password = :password", User.class)
                   .setParameter("login", login)
                   .setParameter("password", password)
                   .uniqueResult());
        }
    }
}
