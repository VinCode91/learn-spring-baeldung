# Dependency Injection and the Spring Context

This is the codebase for Module 'Dependency Injection and the Spring Context' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

# Notes

Defining a bean method as static **will ensure that such beans are created even before the containing configuration class gets initialized**, hence
avoiding triggering other parts of the configuration at that point.
In concrete terms, appConfig bean can't processed by bean BeanPostProcessor beans declared in it without the static keyword.

## Lesson 8 : spring application context
You can remove @SpringBootApplication and only apply @EnableAutoConfiguration on LsApp.
This way, only the context programmatically created is active
