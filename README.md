# Deep Dive Into Spring Boot

This is the codebase for Module  'Deep Dive Into Spring Boot' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

## M4L1
Boot relies on the @Conditional annotation and on a number of variations to drive auto-configuration:

- @ConditionalOnClass : mentioned classes must be in the classpath
- @ConditionalOnMissingClass,
- @ConditionalOnBean,
- @ConditionalOnMissingBean

*logging.level.org.springframework.boot.autoconfigure=DEBUG* allows to get a report on the autoconfiguration like :
- Positive matches – auto-configurations that are enabled as their condition was matched
- Negative matches – auto-configuration classes with conditions evaluated to false, which remain disabled
- Exclusions – classes we exclude
- Unconditional classes – configurations without conditions

**the whole “magic” of Spring Boot is based on the @ConditionalOn* annotations. It uses them in order to control whether various useful artifacts are present in the project (on the classpath) or not. If present, they get used, otherwise their alternatives are used.**

## M4L2
**We can also configure the logging level for individual loggers at runtime by hitting the POST /loggers/{{logger}} request.**

For example, we can set the ROOT logging level to DEBUG in our app by hitting the endpoint:

POST http://localhost:8080/monitoring/loggers/ROOT  (because we have property *management.endpoints.web.base-path=/monitoring*)

with the payload:

    {
        "configuredLevel": "DEBUG"
    }
