## Job4j Todo Application

A simple Todo web application built with Spring Boot, Thymeleaf, Hibernate, and PostgreSQL.
This project allows users to create, edit, delete, and track tasks with a clean and user-friendly interface.

## Features

- Task Management:
  - Create new tasks with descriptions.
  - Edit existing tasks, including marking them as completed.
  - Delete tasks.

- Task Status:
  - Display task status as "Completed" or "Not Completed".

- Task Listing:
  - View all tasks or filter by completed / new tasks.
  - Tasks are displayed with creation date formatted in a readable way.

- Responsive UI:
  - Built using Bootstrap 5 for a clean and responsive interface.

- Database Integration:
  - Tasks are stored in a PostgreSQL database using Hibernate ORM.
  - Database schema managed with Liquibase migrations.
  
## Technologies Used

- Java 17
- Spring Boot 2.7.3
- Spring MVC / Spring Web
- Thymeleaf
- Hibernate ORM
- PostgreSQL
- Liquibase
- Bootstrap 5
- Maven

## Requirements

To run this project, make sure you have installed:

| Technology | Version |
|-----------|---------|
| **Java** | 17+ |
| **Maven** | 3.6+ |
| **PostgreSQL** | 14+ |
| **Git** | any |
| **IDE (optional)** | IntelliJ IDEA / Eclipse / VS Code |

---

## Environment Setup

### 1️ Clone the repository
```bash
git clone https://github.com/1oogabooga1/job4j_todo.git
cd job4j_todo
 ```
### 2️ Configure PostgreSQL database
Create a database: 
```bash
CREATE DATABASE todo;
```
### 3️ Database Migrations (Liquibase)
To run migrations manually:
```bash
mvn liquibase:update
```

## Launch the Application
Start the Spring Boot app:
```bash
mvn spring-boot:run
```

##  Application URLs

| Page               | URL                                     |
|--------------------|-------------------------------------------|
| All tasks          | http://localhost:8080/tasks/list          |
| Create task        | http://localhost:8080/tasks/create        |
| New tasks          | http://localhost:8080/tasks/newTasks      |
| Completed tasks    | http://localhost:8080/tasks/doneTasks     |

## Screenshots
<img width="1439" height="560" alt="image" src="https://github.com/user-attachments/assets/48ebe1df-e056-481d-8f08-768009b7732e" />

<img width="1439" height="547" alt="Снимок экрана 2026-03-31 в 12 21 25" src="https://github.com/user-attachments/assets/053ccc05-6765-40db-a7ee-2e8da5c28a94" />

<img width="1440" height="596" alt="Снимок экрана 2026-03-31 в 12 24 16" src="https://github.com/user-attachments/assets/f6d346ef-cf6e-41f5-8f98-964bbfd5d4f7" />

<img width="1440" height="806" alt="Снимок экрана 2026-03-31 в 12 22 30" src="https://github.com/user-attachments/assets/0c994a96-d782-43b1-8029-a9df0d9f99d3" />

<img width="1439" height="541" alt="Снимок экрана 2026-03-31 в 12 23 59" src="https://github.com/user-attachments/assets/78591174-dea2-4c08-8275-5f279583098b" />

<img width="1440" height="530" alt="Снимок экрана 2026-03-31 в 12 23 21" src="https://github.com/user-attachments/assets/636171a6-a3d1-4724-98d8-54ae4e56b0c7" />

<img width="1440" height="529" alt="Снимок экрана 2026-03-31 в 12 24 04" src="https://github.com/user-attachments/assets/354f71c1-5afe-43a2-860a-0997d3981585" />

<img width="1437" height="390" alt="Снимок экрана 2026-03-31 в 12 24 36" src="https://github.com/user-attachments/assets/66f2a2d2-99ef-4af7-8f83-64a465cfe5ff" />

<img width="1439" height="424" alt="Снимок экрана 2026-03-31 в 12 25 04" src="https://github.com/user-attachments/assets/a3ba02aa-64dc-43bd-9471-6c8bdb72e1e1" />


