# Todo Application

![CI GitHubAction](https://github.com/1oogabooga1/job4j_todo/actions/workflows/maven.yml/badge.svg)

A simple Todo web application built with Spring Boot, Thymeleaf, Hibernate, and PostgreSQL.
This project allows users to create, edit, delete, and track tasks with a clean and user-friendly interface.

## Features

- Task Management:
  - Create new tasks with title, description, priority and categories.
  - Edit existing tasks, including marking them as completed.
  - Delete tasks.

- Task Status:
  - Display task status as "Completed" or "In process".
  - Display task priority such as "urgently", "normal" or "unnecessary"
  - Display task categories such as "sports", "daily", "studies" and "free time".

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

<img width="1440" height="717" alt="Снимок экрана 2026-04-07 в 15 48 26" src="https://github.com/user-attachments/assets/91e00925-3058-40e9-a745-8debab35a9d7" />

<img width="1440" height="899" alt="Снимок экрана 2026-04-07 в 15 48 36" src="https://github.com/user-attachments/assets/2fec4205-d7b0-4d61-ab27-c7349f2815bd" />

<img width="1436" height="831" alt="Снимок экрана 2026-04-04 в 19 56 48" src="https://github.com/user-attachments/assets/0f490fe5-b334-44df-ba0a-1ecb1854e45e" />

<img width="1440" height="802" alt="Снимок экрана 2026-04-04 в 19 57 42" src="https://github.com/user-attachments/assets/eb5e0719-9f7f-4829-8a12-6bf1759c42f3" />

<img width="1435" height="816" alt="Снимок экрана 2026-04-04 в 19 58 50" src="https://github.com/user-attachments/assets/656d837e-ef18-4c57-8db7-16e17bdfd563" />

<img width="1440" height="712" alt="Снимок экрана 2026-04-04 в 19 59 04" src="https://github.com/user-attachments/assets/a55192e5-6c82-498f-a22b-66bd02675771" />

<img width="1439" height="591" alt="Снимок экрана 2026-04-04 в 19 59 21" src="https://github.com/user-attachments/assets/476e0e71-8a3b-4994-b5bf-e34ad999f01d" />

<img width="1440" height="651" alt="Снимок экрана 2026-04-04 в 19 59 29" src="https://github.com/user-attachments/assets/8efaa97f-4b39-42de-8a04-d1ee2f6de145" />

<img width="1438" height="816" alt="Снимок экрана 2026-04-04 в 20 03 12" src="https://github.com/user-attachments/assets/2650e160-d54e-4519-943a-a3df14be9513" />

<img width="1440" height="642" alt="Снимок экрана 2026-04-04 в 20 03 26" src="https://github.com/user-attachments/assets/a67e4205-1a90-4eec-92b0-e9b28160774b" />

<img width="1440" height="460" alt="Снимок экрана 2026-04-04 в 20 03 42" src="https://github.com/user-attachments/assets/53a043b8-1c4f-47bb-8c81-50831e67f309" />

<img width="1440" height="461" alt="Снимок экрана 2026-04-04 в 20 04 02" src="https://github.com/user-attachments/assets/852a8a60-04b3-4d74-918b-941624e6e68a" />






