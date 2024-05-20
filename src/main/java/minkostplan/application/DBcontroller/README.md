# DBController Directory

This directory contains controllers responsible for direct interactions with the database. These controllers handle data retrieval and manipulation tasks based on the application's requirements.

## Responsibilities
- Communicate with the repository layer to fetch and store data.
- Manage transactions.
- Ensure data integrity and handle exceptions.

## Classes Overview

### `GenericJdbcRepository`
This class provides generic JDBC repository functionalities for data access operations. It implements the `SimpleDataAccess` interface to handle CRUD operations generically for any entity type.

#### Responsibilities
- Retrieve and manipulate data in the database using JDBC.
- Implement generic methods for common data access operations.

### `SimpleDataAccess`
This interface defines basic CRUD operations for data access. It is implemented by classes like `GenericJdbcRepository` to provide a consistent API for data operations.

#### Methods
- `findByProperty(String property, Object value)`: Finds an entity by a specific property.
- `findAll()`: Retrieves all entities of a given type.

## Usage
Controllers in this directory are utilized by the service layer to perform complex data operations required by the application's business logic.
