# JDBC Project (MVC Architecture)

This project is a **Java-based application using JDBC (Java Database Connectivity)** that follows a layered **MVC-style architecture**. It demonstrates how to interact with a relational database using **plain JDBC** while maintaining a clean separation of concerns through Controller, Service, DAO, and Model layers.

## Key Features

- JDBC-based database connection
- MVC-inspired layered architecture
- CRUD operations on database entities
- Input validation and utility helpers
- Clear separation between business logic and data access
- Console / view-based interaction

## Project Architecture
jdbc_project/
src/main/java/jdbc/
- controller/ # Handles user requests and application flow
- service/ # Business logic layer
- dao/ # Database access using JDBC
- model/ # Entity / data models
- validator/ # Input validation logic
- utils/ # Utility classes (DB connection, helpers)
- view/ # Console or UI-related classes

## Technologies Used

- **Java**
- **JDBC (Java Database Connectivity)**
- **MySQL / PostgreSQL / SQLite** (configurable)
- **Maven** (optional)
- **SQL**


## Prerequisites

- JDK 8 or higher
- A relational database (MySQL / PostgreSQL / SQLite)
- JDBC driver added to classpath

