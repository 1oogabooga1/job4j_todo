package ru.job4j.todo.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class HblTaskRepository implements TaskRepository {

    private final SessionFactory sessionFactory;

    public HblTaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Task createNewTask(Task task) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            task.setCreated(LocalDateTime.now());
            session.save(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при сохранении новой задачи", e);
        } finally {
            session.close();
        }
        return task;
    }

    @Override
    public Optional<Task> findById(int id) {
        try (Session session = sessionFactory.openSession()) {
           return session.createQuery("FROM Task WHERE id = :id", Task.class)
                   .setParameter("id", id)
                   .uniqueResultOptional();
        }
    }

    @Override
    public boolean deleteTask(int id) {
        Session session = sessionFactory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            result = session.createQuery("DELETE Task WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при удалении задачи", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean editTask(Task task, int id) {
        Session session = sessionFactory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            result = session.createQuery("UPDATE Task SET "
                            + "name = :name, "
                            + "description = :description, "
                            + "done = :done "
                            + "WHERE id = :id")
                    .setParameter("name", task.getName())
                    .setParameter("description", task.getDescription())
                    .setParameter("done", task.isDone())
                    .setParameter("id", id)
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при редактировании задачи", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Task> getAllTasks() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Task", Task.class).list();
        }
    }

    @Override
    public List<Task> getNewOrDoneTasks(boolean done) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Task WHERE done = :done", Task.class)
                    .setParameter("done", done).list();
        }
    }
}
