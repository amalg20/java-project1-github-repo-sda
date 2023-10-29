# Restaurant Management System

![th](https://github.com/amalg20/java-project1-github-repo-sda/assets/145042005/e872eff3-0d45-4c16-86a4-b157de0ab2ab)



## 1. Description of the project:

This project provides a template to build a restaurant management web application using Spring Boot. It contains four main entity classes - Staff, MenuItem Room and Order. Staff represents employees working at the restaurant. MenuItem represents food/drink items on the menu. Room represents the reservation rooms . Order represents orders placed by customers.

There is a one-to-many relationship between Staff and Order, as one staff member can handle multiple orders. There is also a many-to-one relationship between Order and MenuItem, as one order contains multiple menu items.

The MenuItem entity has an embedded Author property to track which staff member created the menu item.

Each of the entities has a Spring Data JPA repository for database operations. There are also controller classes to handle REST API endpoints and service classes that contain business logic.

Unit and integration tests are provided for the repository and controller methods

## 2. Class Diagram:

![RestaurantManagementSystem](https://github.com/amalg20/java-project1-github-repo-sda/assets/145042005/c8361a5f-a66c-40b3-90ba-6cc065f51cd4)

## 3. Setup:

To setup the project I used:
**i. Java 17**
**ii. Maven**

## 4. Technologies Used:

1. Spring Boot 3.1.5
2. Maven
3. Junit 5
4. Postman
5. DBeaver

## 5. Controllers and Routes structure:

**1.MenuItemController:**

A. /api/menu-items/ : Get All MenuItems

B. /api/menu-items/+ menuItem.getId() : Update MenuItem

C. /api/menu-items/ + menuItem.getId() : Delete MenuItem

**2.OrderController:**

A. /api/orders/ : Get All Orders

B. /api/orders/ + order.getId() : Update Order

C. /api/orders/ + order.getId() : Delete Order

**3.StaffController:** 

A. /api/staff/ : Get All Staffs

B. /api/staff/ + staff.getId() : Update Staff

C. /api/staff/ + staff.getId() : Delete Staff

## 6. Steps:

1) Created Spring Boot project with Maven and Java 
2) Defined Staff, MenuItem Room and Order model classes under entity package
3) Added JPA annotations and relationships between entities
4) Tested repositories by saving and fetching sample data
5) Created REST controllers for CRUD operations on entities
6) Moved controller logic to service classes
7) Wrote MockMVC tests for controller methods
8) Implemented exception handling with @ControllerAdvice
9) Configured MySQL database with Spring Data JPA
10) Used Git for version control and GitHub for remote repo

## 7. Extra links : 


## 8. Future Work:
1. I will increase the number of entity
2. I will use Authentication implemented with Spring Security.

## 9. Resources:
1. https://edynamiclearning.com/course/introduction-to-restaurant-management/

## Thank you! :)
