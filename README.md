# Restaurant Management System

## Description of the project:

This project provides a template to build a restaurant management web application using Spring Boot. It contains four main entity classes - Staff, MenuItem Room and Order. Staff represents employees working at the restaurant. MenuItem represents food/drink items on the menu. Room represents the reservation rooms . Order represents orders placed by customers.

There is a one-to-many relationship between Staff and Order, as one staff member can handle multiple orders. There is also a many-to-one relationship between Order and MenuItem, as one order contains multiple menu items.

The MenuItem entity has an embedded Author property to track which staff member created the menu item.

Each of the entities has a Spring Data JPA repository for database operations. There are also controller classes to handle REST API endpoints and service classes that contain business logic.

Unit and integration tests are provided for the repository and controller methods

## Class Diagram:

![RestaurantManagementSystem](https://github.com/amalg20/java-project1-github-repo-sda/assets/145042005/c8361a5f-a66c-40b3-90ba-6cc065f51cd4)

## Steps:

1) Created Spring Boot project with Maven and Java 
2) Defined Staff, MenuItem and Order model classes under entity package
3) Added JPA annotations and relationships between entities
4) Tested repositories by saving and fetching sample data
5) Created REST controllers for CRUD operations on entities
6) Moved controller logic to service classes
7) Wrote MockMVC tests for controller methods
8) Implemented exception handling with @ControllerAdvice

9) Configured MySQL database with Spring Data JPA
10) Used Git for version control and GitHub for remote repo

## Thank you! :)
