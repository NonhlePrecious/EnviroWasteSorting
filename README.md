# Waste Sorting Application

This is an educational tool application that aims to empower users to make environmentally conscious decisions,
by providing essential information on waste sorting, disposal guidelines, and recycling tips.
The goal is to create a user-friendly and informative tool that contributes to a greener planet by properly managing waste.

# Features

1. Waste Category Lookup: Easily search and find information on different waste categories.
2. Disposal Guidelines: Access detailed guidelines on how to properly dispose of various types of waste.
3. Recycling Tips: Discover practical tips and advice on recycling to help reduce environmental impact.


# Technology Used

Spring Boot: For developing the backend services.
H2 Database: An in-memory database for development and testing.
RESTful API: To facilitate communication between the frontend and backend.
Java: The primary programming language used.
Maven: For project management and dependency management.
Posman: For API documentation.
      : Testing using endpoints

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database](https://www.h2database.com/)
- [Postman](https://www.postman.com/)

# Architecture
The Waste Sorting Mobile Application follows a client-server architecture, where the frontend mobile application interacts with the backend server through RESTful APIs.

1. Backend Structure
Package Structure: All backend code is organized under the package com.enviro.assessment.grad001.nonhlemavimbela;.
   The application follows a layered architecture:
- **Model:** Defines the data structures ([WasteCategory.java](src/main/java/com/enviro/assessment/grad001/yournameandsurname/model/WasteCategory.java)).
- **Repository:** Handles data access ([WasteCategoryRepository.java](src/main/java/com/enviro/assessment/grad001/yournameandsurname/repository/WasteCategoryRepository.java)).
- **Service:** Contains business logic ([WasteCategoryService.java](src/main/java/com/enviro/assessment/grad001/yournameandsurname/service/WasteCategoryService.java)).
- **Controller:** Exposes REST endpoints ([WasteCategoryController.java](src/main/java/com/enviro/assessment/grad001/yournameandsurname/controller/WasteCategoryController.java)).

REST Endpoints:
Waste Categories:
Use th the endpoints to retrieve information
      GET /waste-categories: Retrieve a list of all waste categories.
      GET /waste-categories/{id}: Retrieve a list of all waste categories.
      GET /waste-categories/waste-type/{wasteType}: Retrieve a list of all waste categories.
      POST /waste-categories: Add a new waste category.
      PUT /waste-categories/{id}: Update an existing waste category.
      DELETE /waste-categories/{id}: Delete a waste category.
   
Disposal Guidelines:
      GET /disposal-guidelines: Retrieve disposal guidelines.
      GET /disposal-guidelines/{id}: Retrieve disposal guidelines.
      GET /disposal-guidelines/waste-type/{wasteType}: Retrieve disposal guidelines.
      POST /disposal-guidelines: Add new disposal guidelines.
      PUT /disposal-guidelines/{id}: Update disposal guidelines.
      DELETE /disposal-guidelines/{id}: Delete disposal guidelines.
   
Recycling Tips:
      GET /recycling-tips: Retrieve a list of recycling tips.
      GET /recycling-tips/{id}: Retrieve a list of recycling tips.
      GET /recycling-tips/waste-type/{wasteType}: Retrieve a list of recycling tips.
      POST /recycling-tips: Add a new recycling tip.
      PUT /recycling-tips/{id}: Update an existing recycling tip.
      DELETE /recycling-tips/{id}: Delete a recycling tip.

2. Data Management:
      Each record is identified by a primary key called id.
      Data is stored and managed in an in-memory H2 database for rapid development and testing.
   
4. Validation:
      Input validation is implemented using Spring Boot validation annotations to ensure data integrity and validity.
   
5. Frontend-Backend Interaction
    The frontend mobile application communicates with the backend server through the exposed RESTful APIs.
   uses JSON-formatted responses to ensure structured and consistent data exchange.

# Error Handling:

ResourceNotFoundException:
custom exception class is used in this Spring Boot application,
to signal that a requested resource was not found and is being thrown from the controller methods,
and it can be handled by a global exception handler (which is also used) 
to return a meaningful error response to the client.

Custom Error Response Class: The class defines the structure of the error response ,
Response Entity is used to return detailed error responses to the client, ensuring that errors are communicated clearly and consistently.


# API Setting Up a Spring Boot REST API

Create a Spring Boot application with endpoints for managing waste categories.

1. Create a Spring Boot Project
   You can create a Spring Boot project using Spring Initializr (https://start.spring.io/). 
2. Choose the following options:

Project: Maven
Language: Java
Spring Boot: 2.7.x or any latest version
Dependencies: Spring Web, Spring Data JPA, H2 Database, Spring Boot DevTools

# To get started interacting with the APP

Installation and Setup
To set up the backend server, follow these steps:

Clone the Repository:
git clone https://github.com/NonhlePrecious/EnviroWasteSorting.git
Navigate to the Project Directory:

cd EnviroWasteSorting
Install Dependencies:
mvn install
Run the Application:
mvn spring-boot:run
      
