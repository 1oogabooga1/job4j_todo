package ru.job4j.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.User;
import ru.job4j.todo.repository.UserRepository;

import java.util.Optional;

@Service
@Slf4j
public class SimpleUserService implements UserService {

    private final UserRepository repository;

    public SimpleUserService(UserRepository hblUserRepository) {
        this.repository = hblUserRepository;
    }

    @Override
    public Optional<User> create(User user) {
        return repository.create(user);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }
}
