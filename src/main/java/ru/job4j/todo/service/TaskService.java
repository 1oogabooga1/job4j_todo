package ru.job4j.todo.service;

import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createNewTask(Task task);

    Optional<Task> findById(int id);

    boolean deleteTask(int id);

    boolean editTask(Task task, int id);

    List<Task> getAllTasks();

    List<Task> getNewOrDoneTasks(boolean done);
}
