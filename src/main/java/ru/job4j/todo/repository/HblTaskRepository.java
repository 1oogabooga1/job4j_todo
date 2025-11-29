package ru.job4j.todo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
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
            task.setCreated(Timestamp.valueOf(LocalDateTime.now()));
            session.save(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
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
    public void deleteTask(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Task WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean editTask(Task task, int id) {
        Session session = sessionFactory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            result = session.createQuery("UPDATE Task SET description = :description, "
                            + "done = :done WHERE id = :id")
                    .setParameter("description", task.getDescription())
                    .setParameter("done", task.isDone())
                    .setParameter("id", id)
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
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
