# Product API

A **Spring Boot RESTful API** for performing CRUD operations on products. The application uses **Spring Data JPA**, **Bean Validation**, **Spring Security**, and **MySQL** for persistence. API documentation is provided via **Swagger (OpenAPI)**.

---

## Table of Contents

* [Features](#features)
* [Tech Stack](#tech-stack)
* [Requirements](#requirements)
* [Setup & Installation](#setup--installation)
* [Database Configuration](#database-configuration)
* [Running the Application](#running-the-application)
* [API Endpoints](#api-endpoints)
* [Validation & Error Handling](#validation--error-handling)
* [Swagger UI](#swagger-ui)
* [Authentication](#authentication)
* [License](#license)

---

## Features

* CRUD operations for products: create, read, update, delete.
* Input validation using Bean Validation (JSR 380).
* Global exception handling with meaningful error responses.
* API documentation with Swagger UI.
* Basic authentication using Spring Security.
* MySQL database integration using Spring Data JPA.

---

## Tech Stack

* **Java 17**
* **Spring Boot 3.1.x**
* **Spring Data JPA**
* **Spring Security 6.x**
* **Bean Validation (JSR 380)**
* **Swagger/OpenAPI 2.1.0**
* **MySQL**
* **Maven**

---

## Requirements

* Java 17+
* Maven 3.8+
* MySQL 8+ (or PostgreSQL if configured)

---

## Setup & Installation

1. **Clone the repository**:

```bash
git clone https://github.com/yourusername/product-api.git
cd product-api
```

2. **Configure database connection** in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Build the project**:

```bash
mvn clean install
```

4. **Run the application**:

```bash
mvn spring-boot:run
```

---

## Database Configuration

* The application uses **Spring Data JPA** to interact with MySQL.
* The `Product` entity has the following fields:

| Field       | Type   | Constraints                 |
| ----------- | ------ | --------------------------- |
| id          | Long   | Primary Key, Auto-generated |
| name        | String | Not null, 2-100 characters  |
| description | String | Optional, up to 500 chars   |
| price       | Double | Not null, > 0               |

---

## API Endpoints

| Method | Endpoint         | Description             |
| ------ | ---------------- | ----------------------- |
| GET    | `/products`      | Get all products        |
| GET    | `/products/{id}` | Get product by ID       |
| POST   | `/products`      | Create a new product    |
| PUT    | `/products/{id}` | Update existing product |
| DELETE | `/products/{id}` | Delete product by ID    |

---

## Validation & Error Handling

* Input fields are validated using **Bean Validation**:

| Field       | Validation               |
| ----------- | ------------------------ |
| name        | Not blank, size 2-100    |
| price       | Not null, greater than 0 |
| description | Max 500 characters       |

* **GlobalExceptionHandler** returns structured error responses:

```json
{
  "timestamp": "2025-09-11T10:30:00",
  "message": "Validation failed",
  "details": "{name=Name is required, price=Price must be greater than zero}"
}
```

* `NoSuchElementException` for missing products returns `404 Not Found`:

```json
{
  "timestamp": "2025-09-11T10:32:00",
  "message": "Product not found with id 100",
  "details": "uri=/products/100"
}
```

---

## Swagger UI

* API documentation is available at:

```
http://localhost:8085/swagger-ui/index.html
```

* Swagger allows testing all endpoints directly from the browser.

---

## Authentication

* Basic authentication is enabled via **Spring Security**.
* Default credentials (for testing):

```
Username: admin
Password: 1234
```

* Access to API endpoints requires authentication; Swagger UI prompts for credentials.

---

## License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

This README covers:

* Project setup
* Database & entity info
* Validation and error handling
* Swagger documentation
* Authentication
=
