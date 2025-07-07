# 📦 DelAgenda API

DelAgenda is a **RESTful API** built with **Java** and **Spring Boot** for managing deliveries and users. This project implements JWT-based authentication, unit testing with JUnit and Mockito, database versioning with Flyway, and API documentation using Swagger.

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **JWT** for authentication and authorization
- **Flyway** for database migrations
- **Swagger (Springdoc OpenAPI)** for API documentation
- **JUnit 5 & Mockito** for unit testing
- **Lombok** for reducing boilerplate code

---

## 🚀 Features

- User registration and login with JWT
- Role-based access control
- Delivery creation and management
- Item management
- Auto-generated API documentation with Swagger UI
- Secure endpoints with stateless authentication
- Modular project structure

---

## 🔐 Authentication

All protected routes require a **JWT token** provided at login. Token-based authentication is handled via Spring Security and custom filters.

---

## 📄 API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui.html

---

## 🧪 Testing

The project includes unit tests written using **JUnit 5** and **Mockito**, focusing on service and repository layers.

---

## 🗄️ Database Migrations

**Flyway** is used to manage and version the database schema with SQL scripts stored in `resources/db.migration`.

---

## 🏁 Getting Started

### Prerequisites

- Java 21
- Maven

### Run Locally

```bash
git clone https://github.com/GustavoCruzzz/DelAgendaBackEnd.git
cd DelAgendaBackEnd
./mvnw spring-boot:run
