package ru.job4j.todo.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.User;

import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class HblUserRepository implements UserRepository {

    private final CrudRepository crudRepository;

    public HblUserRepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Optional<User> create(User user) {
        Optional<User> result = Optional.empty();
        try {
            crudRepository.run(session -> session.save(user));
            result = Optional.of(user);
        } catch (IllegalStateException e) {
            log.error("Some error occurred during saving new user", e);
        }
        return result;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return crudRepository.optional("FROM User WHERE login = :login AND password = :password", User.class,
                Map.of("login", login, "password", password));
    }
}
