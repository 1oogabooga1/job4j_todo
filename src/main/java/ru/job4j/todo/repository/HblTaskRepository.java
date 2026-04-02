package ru.job4j.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HblTaskRepository implements TaskRepository {

    private final CrudRepository crudRepository;

    @Override
    public Task createNewTask(Task task) {
        task.setCreated(LocalDateTime.now());
        crudRepository.run(session -> session.save(task));
        return task;
    }

    @Override
    public Optional<Task> findById(int id) {
        return crudRepository.optional("FROM Task t JOIN FETCH t.priority WHERE t.id = :id", Task.class, Map.of("id", id));
    }

    @Override
    public boolean deleteTask(int id) {
        return crudRepository.run("DELETE FROM Task t WHERE t.id = :id", Map.of("id", id)) > 0;
    }

    @Override
    public boolean editTask(Task task, int id) {
        return crudRepository.run("UPDATE Task SET "
                + "name = :name, "
                + "description = :description, "
                + "done = :done, "
                + "priority = :priority "
                + "WHERE id = :id",
                Map.of("name", task.getName(),
                "description", task.getDescription(),
                "done", task.isDone(),
                "priority", task.getPriority(),
                "id", id)) > 0;
    }

    @Override
    public boolean doneTask(boolean done, int id) {
        return crudRepository.run("UPDATE Task t SET t.done = :done WHERE t.id = :id AND t.done <> :done",
                Map.of("done", done, "id", id)) > 0;
    }

    @Override
    public List<Task> getAllTasks() {
        return crudRepository.query("FROM Task t JOIN FETCH t.priority", Task.class);
    }

    @Override
    public List<Task> getNewOrDoneTasks(boolean done) {
        return crudRepository.query("FROM Task t JOIN FETCH t.priority WHERE t.done = :done", Task.class,
                Map.of("done", done));
    }
}
