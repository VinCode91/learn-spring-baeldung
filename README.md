# Dependency Injection and the Spring Context

This is the codebase for Module 'Dependency Injection and the Spring Context' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

# Notes

Defining a bean method as static **will ensure that such beans are created even before the containing configuration class gets initialized**, hence
avoiding triggering other parts of the configuration at that point.
In concrete terms, appConfig bean can't processed by bean BeanPostProcessor beans declared in it without the static keyword.

## Lesson 8 : spring application context
You can remove @SpringBootApplication and only apply @EnableAutoConfiguration on LsApp.
This way, only the context programmatically created is active

## Lesson 9 : @Resource @Inject
According to the JSR-250 specificaction, **the @Resource annotation serves to identify the target component by its unique name.
This annotation can be used at the field and method level (setter), but not at the constructor level**.

Like the @Autowired annotation, **the @Inject annotation can be used at the field and method level as well as at the constructor level**.

## Common wiring issues

- NoSuchBeanDefinitionException
- NoUniqueBeanDefinitionException
- BeanCurrentlyInCreationException : usually happens when there is a circular dependency in the context

Circular dependency implies a design flaw. If we enable the *spring.main.allow-circular-references* property as suggested in the logs, the framework will attempt to automatically break the cycle, but even then there might be cases in which this is not possible. In fact, our example is one such case.

An important point here is that this problem arises when Spring is attempting to create the two interdependent beans at
the same time. But if we hold off on fully injecting one bean into the other until it’s needed, then it doesn’t interfere
with context loading during startup. **One way to tell Spring to not fully initialize the dependent bean during startup,
and instead create a proxy, is to use the @Lazy annotation**.

