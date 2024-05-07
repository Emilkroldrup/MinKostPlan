# Test Directory

### This is not the final README of this, as we are not doing testdriven development, but this is a brief overview of what we should aim at getting.

This directory contains all the test code for the application. It's crucial for verifying the functionality and reliability of the application through automated testing.

## Responsibilities
- House unit tests that verify the functionality of individual methods and components under isolated conditions.
- Contain integration tests that ensure various components of the application work together correctly.
- Include end-to-end tests that simulate user interactions with the application to verify its flow from start to finish.

## Types of Tests
- **Unit Tests**: Focus on small, isolated parts of the application. Typically, these tests ensure that individual functions or classes behave as expected.
- **Integration Tests**: Test the interactions between components at a high level, ensuring that integrated components function together as expected.
- **End-to-End Tests**: Simulate real user scenarios from beginning to end to ensure the system as a whole behaves as expected in a production-like environment.

## Frameworks and Tools
- **JUnit**: Primarily used for unit testing in Java applications.
- **Spring Boot Test**: Provides integration test functionality for Spring Boot applications, simplifying the process of setting up and configuring tests.
- **Mockito**: Used for mocking objects in unit tests to isolate the components being tested.
- **Selenium**: Used for end-to-end testing of web applications by automating browser actions.

## Usage
To maintain high code quality and ensure reliability, tests should be run before any new code is merged into the main codebase. Continuous Integration (CI) systems can automate this process to run tests automatically on every push to the repository.

## Running Tests
Tests can be executed from the IDE or via the command line using Maven or Gradle commands, depending on the project's setup.

```bash
# Example of running tests with Maven
mvn test
