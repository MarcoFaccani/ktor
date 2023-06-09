## Project Overview
This project serves as my introductory project for the KTor framework, aiming to explore its features and gain familiarity with its usage. The project is implemented using the following technologies and libraries:

- `Ktor` Framework
- `Kotlin` programming language
- `Koin` dependency injection framework
- `kotlin-test` native Kotlin testing library
- `KoTest` external testing library
- `Mockk` for mocking objects in unit tests

## Functionalities
The project incorporates the following functionalities:

1. Dependency Injection: Since KTor does not provide built-in dependency injection like Spring Boot, an external framework needs to be imported. In this project, I have chosen to use Koin for dependency injection.

2. REST API with Path Parameter Validation: The project exposes a REST API that accepts path parameters and validates them. If the parameters are invalid, the API returns a 404 Bad Request response.

3. Third-Party REST API Integration: The project demonstrates the usage of the CIO client to make requests to a third-party REST API. Configuring a different client, such as HttpOk, is also feasible and straightforward.

4. Serialization and Deserialization: The project utilizes the serialization and deserialization capabilities provided by the KTor library.

5. Unit Testing: Unit tests are implemented using the kotlin-test, KoTest, and Mockk libraries. Although not strictly necessary, I incorporated KoTest out of curiosity and found it to be a valuable addition.

6. Application-Level Exception Handling: The project incorporates application-level exception handling, similar to the @ExceptionHandler mechanism in Spring Boot.
   
## Exposed API
   The exposed API allows for currency conversion between different currencies. The following path parameters are required:

- from: The currency acronym to convert from.
- to: The currency acronym to convert to.
- amount: The amount to convert.

Example endpoint: l`ocalhost:8080/financial/currency:convert?from=USD&to=EUR&amount=100`


## Running the app
To run the application, you will need to obtain an API key from the third-party service, ApiLayer, with which this application integrates.
> Please note that this project was developed as a quick exercise to gain familiarity with KTor. As a result, there are several aspects that could be improved. For example, it would be preferable to avoid hard-coding the API key, incorporate integration tests, enhance unit test coverage, and adhere to better SOLID principles.
