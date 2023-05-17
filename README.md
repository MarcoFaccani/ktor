## Overview
This project is my first `KTor` project ever and is meant to explore and get familiar with it.
It uses:
* `Ktor` Framework
* `Kotlin` programming language
* `Koin` dependency injection framework
* `kotlin-test` native kotlin testing library
* `KoTest` external testing library
* `Mockk` to mock objects in unit tests

## Functionalities
The following functionalities have been implemented in this project:
* Dependency Injection - `KTor` doesn't offer out-of-the-box DI as Spring Boot does, so it's required to import an external framework. I chose `Koin`.
* expose a REST API that takes path parameters and validates them, returning `404 Bad Request` if they are invalid
* call third-party REST API using `CIO` client (attempting to configure a different client, such as `HttpOk`, was simple and quick)
* Serialization and Deserialization using KTor lib
* Unit testing using `kotlin-test`, `KoTest` and `Mockk` libraries (KoTest was a plus, wasn't really needed but I was curious to use it)
* Exception handling at application level (equivalent of `@ExceptionHandler` in Spring Boot)


## Exposed API
The exposed API allows to convert a given currency to another one.
Three path parameters must be specified:
* `from` - the currency acronym to convert from
* `to` - the currency acronym to convert to
* `amount` - the amount to convert

Exposed dndpoint: `localhost:8080/financial/currency:convert?from=USD&to=EUR&amount=100`

