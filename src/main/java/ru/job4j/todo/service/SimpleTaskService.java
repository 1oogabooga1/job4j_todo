package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.repository.CategoryRepository;
import ru.job4j.todo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleTaskService implements TaskService {

    private final TaskRepository hblTaskRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Task createNewTask(Task task, List<Integer> ids) {
        task.setCategories(categoryRepository.findById(ids));
        return hblTaskRepository.createNewTask(task);
    }

    @Override
    public Optional<Task> findById(int id) {
        return hblTaskRepository.findById(id);
    }

    @Override
    public boolean deleteTask(int id) {
        return hblTaskRepository.deleteTask(id);
    }

    @Override
    public boolean editTask(Task task, int id, List<Integer> ids) {
        task.setCategories(categoryRepository.findById(ids));
        return hblTaskRepository.editTask(task, id);
    }

    @Override
    public boolean doneTask(boolean done, int id) {
        return hblTaskRepository.doneTask(done, id);
    }

    @Override
    public List<Task> getAllTasks() {
        return hblTaskRepository.getAllTasks();
    }

    @Override
    public List<Task> getNewOrDoneTasks(boolean done) {
        return hblTaskRepository.getNewOrDoneTasks(done);
    }
}
