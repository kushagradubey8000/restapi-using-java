# Spring Boot PostgreSQL Docker CRUD API

A RESTful CRUD API built using **Spring Boot**, **Spring Data JPA**, **PostgreSQL**, and **Docker Compose**.

## Features

* Create, Read, Update, Delete users
* Spring Boot 4
* Spring Data JPA (Hibernate)
* PostgreSQL 17
* Docker & Docker Compose
* REST API tested with Postman

## Tech Stack

* Java 25
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Docker

## API Endpoints

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| GET    | `/api/users`      | Get all users  |
| GET    | `/api/users/{id}` | Get user by ID |
| POST   | `/api/users`      | Create a user  |
| PUT    | `/api/users/{id}` | Update a user  |
| DELETE | `/api/users/{id}` | Delete a user  |

### Example POST Request

```json
{
  "name": "Kushagra",
  "email": "kushagra@example.com"
}
```

## Run with Docker

```bash
docker compose up --build
```

Application: `http://localhost:8080`

## Author

**Kushagra Dubey**
