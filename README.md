# **City Super POS System**

Project Name: City Super POS System.

Developed for: City Super Food City

Purpose: Enhance and streamline sales and inventory management for City Super’s operations.

## **Overview**

The City Super POS (Point of Sale) system is a simplified, efficient solution designed to facilitate inventory and sales management for the "City Super" food city. Built using a modern tech stack, this system enables smooth handling of sales transactions, order management, and inventory updates through a RESTful API. It communicates using JSON to ensure consistency and ease of integration.

## **Features**

**Order Management:** Handles order creation, updates, and status tracking.

**Inventory Management:** Supports adding, updating, and retrieving item data in real time.

**Customer Management:** Stores and retrieves customer data to optimize order processing.

**Sales Tracking:** Provides accurate, real-time sales tracking and reporting.

## **Tech Stack**

**Backend Framework:** Spring Framework (Spring MVC for controller logic, Spring Data JPA for database access)

**ORM:** Hibernate (for mapping Java objects to database tables)

**Database:** MySQL (relational database for structured storage of items, orders, and customers)

**Data Format:** JSON (to handle request and response payloads in a RESTful manner)

## **System Architecture**

The City Super POS System follows an MVC (Model-View-Controller) architecture, where:

**Controller Layer:** Processes incoming JSON requests, manages request routing, and invokes services.

**Service Layer:** Encapsulates business logic and provides services for managing orders, inventory, and customer data.

**Data Access Layer (DAO):** Interacts with the MySQL database through Hibernate ORM, allowing efficient CRUD operations.

## **License**

This project is licensed under the MIT License.