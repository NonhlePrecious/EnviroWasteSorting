# Waste Sorting Application

[Uploading giphy.webp…]()

This is an educational tool application that aims to empower users to make environmentally conscious decisions,
by providing essential information on waste sorting, disposal guidelines, and recycling tips.
The goal is to create a user-friendly and informative tool that contributes to a greener planet by properly managing waste.

# Features

1. Waste Category Lookup: Easily search and find information on different waste categories.
2. Disposal Guidelines: Access detailed guidelines on how to properly dispose of various types of waste.
3. Recycling Tips: Discover practical tips and advice on recycling to help reduce environmental impact.


# Technology Used

- [Spring Boot](https://spring.io/projects/spring-boot) For developing the backend services.
  
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  
- [H2 Database](https://www.h2database.com/) An in-memory database for development and testing.
  
  RESTful API: To facilitate communication between the frontend and backend.
  
  Java: The primary programming language used.
  
  Maven: For project management and dependency management.
  
- [Postman](https://www.postman.com/) For Testing API uendpoints


# Architecture
      The Waste Sorting Mobile Application follows a client-server architecture, where the frontend mobile application interacts with the backend server through RESTful APIs.

1. Backend Structure
      Package Structure: All backend code is organized under the package com.enviro.assessment.grad001.nonhlemavimbela;.
   
       The application follows a layered architecture:
   
    - **Model:** Defines the data structures ([WasteCategory.java](src/main/java/com/enviro/assessment/grad001/nonhlemavimbela/model/WasteCategory.java)).
      
    - **Repository:** Handles data access ([WasteCategoryRepository.java](src/main/java/com/enviro/assessment/grad001/nonhlemavimbela/repository/WasteCategoryRepository.java)).
      
    - **Service:** Contains business logic ([WasteCategoryService.java](src/main/java/com/enviro/assessment/grad001/nonhlemavimbela/service/WasteCategoryService.java)).
      
    - **Controller:** Exposes REST endpoints ([WasteCategoryController.java](src/main/java/com/enviro/assessment/grad001/nonhlemavimbela/controller/WasteCategoryController.java)).


## Testing the API Endpoints with Postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://rest-api-3929.postman.co/workspace/REST-API-Workspace~84973816-e478-4ce0-a5e3-507b76204aa1/request/36672697-ead326a3-78f1-4321-86e2-2238dadec19e?action=share&creator=36672697&ctx=documentation)

### EXAMPLE: Create Waste Category

- **URL:** `http://localhost:5555/waste-categories`
- **Method:** POST
- **Body (JSON):**
  ```json
  {
    "name": "Plastic"
  }


# REST Endpoints

## Waste Categories
Use these endpoints to retrieve information about waste categories.

GET /waste-categories: Retrieve a list of all waste categories.

GET /waste-categories/{id}: Retrieve a waste category by ID.

GET /waste-categories/waste-type/{wasteType}: Retrieve waste categories by waste type.

POST /waste-categories: Add a new waste category.

PUT /waste-categories/{id}: Update an existing waste category.

DELETE /waste-categories/{id}: Delete a waste category.

## Disposal Guidelines
Use these endpoints to retrieve and manage disposal guidelines.

GET /disposal-guidelines: Retrieve a list of all disposal guidelines.

GET /disposal-guidelines/{id}: Retrieve disposal guidelines by ID.

GET /disposal-guidelines/waste-type/{wasteType}: Retrieve disposal guidelines by waste type.

POST /disposal-guidelines: Add new disposal guidelines.

PUT /disposal-guidelines/{id}: Update disposal guidelines.

DELETE /disposal-guidelines/{id}: Delete disposal guidelines.

## Recycling Tips

![Uploading sort.jfif…]()

Use these endpoints to retrieve and manage recycling tips.

GET /recycling-tips: Retrieve a list of recycling tips.

GET /recycling-tips/{id}: Retrieve a recycling tip by ID.

GET /recycling-tips/waste-type/{wasteType}: Retrieve recycling tips by waste type.

POST /recycling-tips: Add a new recycling tip.

PUT /recycling-tips/{id}: Update an existing recycling tip.

DELETE /recycling-tips/{id}: Delete a recycling tip.

## Data Management:
      Each record is identified by a primary key called id.
      Data is stored and managed in an in-memory H2 database for rapid development and testing.
   
## Validation:
      Input validation is implemented using Spring Boot validation annotations to ensure data integrity and validity.
   
## Frontend-Backend Interaction
      The frontend mobile application communicates with the backend server through the exposed RESTful APIs.
      uses JSON-formatted responses to ensure structured and consistent data exchange.

## Error Handling:

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
   
3. Choose the following options:

       Project: Maven
     
        Language: Java
     
        Spring Boot: 2.7.x or any latest version
     
        Dependencies: Spring Web, Spring Data JPA, H2 Database, Spring Boot DevTools

# To get started interacting with the APP

Installation and Setup
To set up the backend server, follow these steps:

  Clone the Repository: git clone https://github.com/NonhlePrecious/EnviroWasteSorting.git
        
    Navigate to the Project Directory:
        
    cd EnviroWasteSorting
        
    Install Dependencies:
        
    mvn install
        
    Run the Application:
  
    mvn spring-boot:run
      
# Reuse, Recycle and Proect the environment for sa greener future!!!!!!!
