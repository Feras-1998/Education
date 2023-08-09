# Education Project

This is the Education Project, a Java Technical Assessment for KFH.

## Project Description

This project is aimed at creating RESTful services for an education site. It involves creating courses, registering students, and various other activities related to student-course interactions.

## Technologies Used

- Spring Boot 3.1.2
- Java 17
- MySQL Database
- JWT Authentication
- Lombok for code generation
- SpringDoc for API documentation (Swagger)

## IDE Used

You can use any Java IDE of your choice to work with this project. Some popular options include (I use IntelliJ IDEA Community Edition):

- IntelliJ IDEA
- Eclipse
- Visual Studio Code

## Dependencies

The project's Maven dependencies are managed in the `pom.xml` file. Key dependencies include:

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- MySQL Connector
- Spring Boot DevTools
- Spring Boot Starter Test
- Spring Security Test
- jjwt library for JWT
- Lombok for code generation
- SpringDoc for API documentation (Swagger)

Please refer to the `pom.xml` for the complete list of dependencies.

## Building and Running

To build and run the project:

1. Configure your MySQL database settings in `application.properties`.
2. Import the project into your chosen IDE.
3. Run the main application class to start the Spring Boot application.
4. Access the application's API documentation using the provided URL (usually `http://localhost:8080/swagger-ui.html`).

## Important URLs

APIs documentation:

1. Swagger (http://localhost:8080/swagger-ui/index.html).
2. Postman (https://documenter.getpostman.com/view/13790770/2s9Xy2QXkN).

## Important Files

DataBase Files:

1. dump-structure.sql (For create empty database). 
2. dump-structure-and-data.sql (For create database with data).

Postman File:
1. Education.postman_collection.json (Import this collection in your postman app for test APIs).
