package ru.job4j.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HblTaskRepository implements TaskRepository {

    private final CrudRepository crudRepository;

    @Override
    public Task createNewTask(Task task) {
        crudRepository.run(session -> session.save(task));
        return task;
    }

    @Override
    public Optional<Task> findById(int id) {
        return crudRepository.optional("SELECT DISTINCT t FROM Task t JOIN FETCH t.priority LEFT JOIN FETCH t.categories "
                + "WHERE t.id = :id", Task.class, Map.of("id", id));
    }

    @Override
    public boolean deleteTask(int id) {
        return crudRepository.run("DELETE FROM Task t WHERE t.id = :id", Map.of("id", id)) > 0;
    }

    @Override
    public boolean editTask(Task task, int id) {
        return crudRepository.tx(session -> {
            Task taskInDb = session.get(Task.class, id);
            if (taskInDb == null) {
                return false;
            }
            taskInDb.setName(task.getName());
            taskInDb.setDescription(task.getDescription());
            taskInDb.setDone(task.isDone());
            taskInDb.setPriority(task.getPriority());
            taskInDb.setCategories(task.getCategories());
            return true;
        });
    }

    @Override
    public boolean doneTask(boolean done, int id) {
        return crudRepository.run("UPDATE Task t SET t.done = :done WHERE t.id = :id AND t.done <> :done",
                Map.of("done", done, "id", id)) > 0;
    }

    @Override
    public List<Task> getAllTasks() {
        return crudRepository.query("SELECT DISTINCT t FROM Task t JOIN FETCH t.priority LEFT JOIN FETCH t.categories", Task.class);
    }

    @Override
    public List<Task> getNewOrDoneTasks(boolean done) {
        return crudRepository.query("SELECT DISTINCT t FROM Task t JOIN FETCH t.priority LEFT JOIN FETCH t.categories WHERE t.done = :done", Task.class,
                Map.of("done", done));
    }
}
