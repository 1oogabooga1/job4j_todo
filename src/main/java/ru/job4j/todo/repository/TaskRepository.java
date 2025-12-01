package ru.job4j.todo.repository;

import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task createNewTask(Task task);

    Optional<Task> findById(int id);

    boolean deleteTask(int id);

    boolean editTask(Task task, int id);

    boolean doneTask(boolean done, int id);

    List<Task> getAllTasks();

    List<Task> getNewOrDoneTasks(boolean done);

}
