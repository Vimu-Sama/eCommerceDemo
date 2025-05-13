# 🛒 E-Commerce Product Service Prototype

This project is a simple prototype representing a small but essential part of an E-Commerce website service. The primary functionality is to create a portal that allows users to **add** and **delete** products from the system. For data persistence, a local **PostgreSQL** database is used, with configuration managed via the `application.properties` file (which may later be excluded using `.gitignore` for security and environment separation).

### 🧭 Application Flow:

ProductController → ProductService → ORM (Hibernate) → Database (PostgreSQL)

1) **ProductController**: Acts as the entry point for HTTP requests. It receives and processes client input, then passes the relevant data to the service layer.

2) **ProductService**: Responsible for handling the business logic. It takes data from the controller, processes it as needed, and communicates with the database through the ORM layer.

3) **ORM (Hibernate + JPA)**: ORM (Object-Relational Mapping) simplifies database interactions by abstracting SQL queries into Java objects. In this project, we use **Hibernate**, a widely adopted ORM tool that implements the **JPA (Java Persistence API)** specification. JPA defines a standard way to map Java objects to relational database tables, allowing developers to switch ORM tools with minimal changes and promoting code reusability and portability.

The project is currently under development, and further enhancements such as update operations, product listing, and user authentication may be added in the future.
The project database is hosted on Supabase and uses postgres for the CRUD operations.
The application.properties has been made private to ensure the privacy of the database hosted remotely. Today's task changed files which are not committed intentionally and more of a click work.
Found new stuff about there being a concept of prepared statement in postgres and they caused error when I was trying to connect with Database
