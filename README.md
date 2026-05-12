# mongoemployee_project

A RESTful Spring Boot application for managing mongoemployees' information (first name, last name, email, department, position, salary) with input validation, DTO pattern(only request DTO) and MapStruct.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Mongodb](https://img.shields.io/badge/-MongoDB-13aa52?style=for-the-badge&logo=mongodb&logoColor=white)
![MapStruct](https://img.shields.io/badge/MapStruct-000000?style=for-the-badge)


## Table of Contents

- [Technologies/Features](#-technologies-/-features)
- [Setup & Installation](#-setup--installation)
- [Running the Application](#-running-the-application)
- [Employee API Endpoints](#-api-endpoints)
- [Contributing](#-contributing)
- [License](#-license)

## Technologies/Features

- Java 17 or Higher version
- Spring Boot 3.2+
- A Non-Relational Database (Mongodb)
- Lombok
- Request DTO
- Bean Validation (`@NotBlank`, `@Size`)
- Global exception handling
- Jakarta Validation
- Maven
- MapStruct
- Git
- IDE: IntelliJ IDEA / VS Code / Eclipse

## Setup & Installation

1. Clone the repository

```bash
git clone https://github.com/musaisah455/mongoemployee_project.git
cd mongoemployee_project
```

### Install dependencies

```
mvn clean install
```

## Running the Application

```
mvn spring-boot:run
```
From IDE: Run DemoApplication.java
Application starts at: http://localhost:8080/api/employees

## Employee API Endpoints

| Method  | Endpoint            |Description
|:--------|:--------------------|:---
| POST    | /api/employees      | Create new employee
| GET     | /api/employees      | Get all employees
| GET     | /api/employees/{id} | Get employee by ID
| PUT     | /employees/{id}     | Update existing employee 
| DELETE  |  /employees/{id}     | Delete existing employee 

## Contributing

Fork the repository

Create your feature branch (git checkout -b amazing feature)

Commit your changes (git commit -m 'Add some amazing feature')

Push to the branch (git push origin amazing feature)

Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

Made by Musa

Last updated: February 2026