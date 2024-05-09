# Repository Directory

## Overview

The `repository` directory contains the data access objects (DAOs) for the MinKostPlan application. These DAOs are responsible for all database interactions within the application, abstracting the logic necessary to access data sources.

## Purpose

The repository layer serves as a bridge between the application's business logic and its data storage mechanisms. Using Spring's Repository pattern, we encapsulate all the data access logic within these repositories to keep the service layers clean and focused solely on business logic.

## Contents

This directory includes classes and interfaces that interact directly with the database. Each repository corresponds to a specific entity in our domain, providing CRUD operations and other necessary queries.

### Files and Descriptions

- `RecipeRepository.java`: Handles data access for the `Recipe` entity.
- `UserRepository.java`: Manages database operations related to `User` information.
- Additional repositories are structured similarly, tailored to their respective entities.

## Technologies

- **Spring Data JPA**: For repositories that extend from `JpaRepository` or `CrudRepository`, facilitating easier data manipulation and reducing boilerplate code.
- **JdbcTemplate**: Used in repositories where custom SQL queries are necessary beyond what Spring Data JPA offers.

## Best Practices

- **Naming Conventions**: Name repository interfaces and classes clearly to reflect the entities they manage. For example, `RecipeRepository` for `Recipe` entity operations.
- **Method Naming**: Follow Spring Data's method naming conventions where possible to take advantage of automatic query generation.
- **Isolation**: Ensure that repository methods remain focused on data access and do not include business logic, which should reside in the service layer.

## Usage

To use a repository, autowire it into your service classes as needed:

```java
@Autowired
private RecipeRepository recipeRepository;

public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
}
