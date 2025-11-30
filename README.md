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
  <img width="1433" height="446" alt="image" src="https://github.com/user-attachments/assets/71a9b357-2b5b-47d7-8e60-cc22037927ad" />
  

<img width="1435" height="822" alt="image" src="https://github.com/user-attachments/assets/45218e27-e6e7-4dc8-9d84-e78a19cefcac" />


