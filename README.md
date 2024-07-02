# Waste Sorting Application

This is an educational tool application that aims to empower users to make environmentally conscious decisions,
by providing essential information on waste sorting, disposal guidelines, and recycling tips.
The goal is to create a user-friendly and informative tool that contributes to a greener planet by properly managing waste.

# Features

#Waste Category Lookup: Easily search and find information on different waste categories.
#Disposal Guidelines: Access detailed guidelines on how to properly dispose of various types of waste.
#Recycling Tips: Discover practical tips and advice on recycling to help reduce environmental impact.


#Technology Used

Spring Boot: For developing the backend services.
H2 Database: An in-memory database for development and testing.
RESTful API: To facilitate communication between the frontend and backend.
Java: The primary programming language used.
Maven: For project management and dependency management.
Posman: For API documentation.
      : Testing using endpoints

#Architecture
The Waste Sorting Mobile Application follows a client-server architecture, where the frontend mobile application interacts with the backend server through RESTful APIs.

1. Backend Structure
Package Structure: All backend code is organized under the package org/enviro365/wastesortingenviro365.

REST Endpoints:
Waste Categories:
      GET /waste-categories: Retrieve a list of all waste categories.
      POST /waste-categories: Add a new waste category.
      PUT /waste-categories/{id}: Update an existing waste category.
      DELETE /waste-categories/{id}: Delete a waste category.
   
Disposal Guidelines:
      GET /disposal-guidelines: Retrieve disposal guidelines.
      POST /disposal-guidelines: Add new disposal guidelines.
      PUT /disposal-guidelines/{id}: Update disposal guidelines.
      DELETE /disposal-guidelines/{id}: Delete disposal guidelines.
   
Recycling Tips:
      GET /recycling-tips: Retrieve a list of recycling tips.
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

6. Error Handling:
7. Custom Error Response Class: The class defines the structure of the error response ,
Response Entity is used to return detailed error responses to the client, ensuring that errors are communicated clearly and consistently.

#To get started

Installation and Setup
To set up the backend server, follow these steps:

Clone the Repository:
git clone https://github.com/Enviro365/waste-sorting-app-backend.git
Navigate to the Project Directory:

cd waste-sorting-app-backend
Install Dependencies:
mvn install
Run the Application:
mvn spring-boot:run

API Documentation
The API documentation is available at /swagger-ui.html once the application is running. This documentation provides detailed information about the available endpoints and how to use them.

#License
      
