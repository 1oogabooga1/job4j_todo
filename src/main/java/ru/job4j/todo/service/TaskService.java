package ru.job4j.todo.service;

import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createNewTask(Task task, List<Integer> ids);

    Optional<Task> findById(int id);

    boolean deleteTask(int id);

    boolean editTask(Task task, int id, List<Integer> ids);

    boolean doneTask(boolean done, int id);

    List<Task> getAllTasks();

    List<Task> getNewOrDoneTasks(boolean done);
}
