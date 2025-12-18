# Advanced Features in Spring

This is the codebase for Module 'Advanced Features in Spring' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

## M9L2
AOP key notions:
- the **Aspect** is, simply put, the actual cross-cutting logic that we want to add
- the **Join Point** – the point during execution of a program where we can hook in our logic to run
- the **Point Cut** – a way to match one or more join points and, as a result, determine where the logic is going to actually run
- the **Advice** – this is the infrastructure around a join-point that runs the Aspect at that Join-Point; in practical terms, this is an interceptor

**A pointcut is a Predicate that is written as an expression, to match the JoinPoint with the advice**
Any PointCUt expression starts with **a PointCut designator that tells what to match**.
For example the **within pointcut designator** matches all the methods declared within a type. *A type here is an expression matching either package names, class names and interfaces*

There are several pointcut designators such as the execution of a method, a type, method arguments or annotations