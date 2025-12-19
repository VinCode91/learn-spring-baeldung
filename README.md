# Advanced Features in Spring

This is the codebase for Module 'Advanced Features in Spring' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

## M9L2: Spring AOP
AOP key notions:
- the **Aspect** is, simply put, the actual cross-cutting logic that we want to add
- the **Join Point** – the point during execution of a program where we can hook in our logic to run
- the **Point Cut** – a way to match one or more join points and, as a result, determine where the logic is going to actually run
- the **Advice** – this is the infrastructure around a join-point that runs the Aspect at that Join-Point; in practical terms, this is an interceptor

**A pointcut is a Predicate that is written as an expression, to match the JoinPoint with the advice**
Any PointCUt expression starts with **a PointCut designator that tells what to match**.
For example the **within pointcut designator** matches all the methods declared within a type. *A type here is an expression matching either package names, class names and interfaces*

There are several pointcut designators such as the execution of a method, a type, method arguments or annotations

### Spring AOP vs AspectJ
Spring interprets the annotations of AspectJ, but the runtime is still pure Spring AOP.
The lower-level AOP API can also be used to define aspects programmatically, but this is less common. **Spring itself recommends to use the @AspectJ annotation style for most cases**.

Besides Spring AOP implementation performs runtime weaving by using proxies, while AspectJ performs weaving at the compile time by using the AspectJ compiler.
Due to this proxy-based nature of Spring AOP, the advices apply only on public methods. To intercept private or protected methods as well we can use AspectJ.

## M9L3: Spring Expresion Language (SpEL)
**pEL is quite a powerful expression language which basically supports querying and manipulating the full object graph at runtime**

When referencing bean in SpEL expression, make sure to use actual bean names (mentioned for example in @Qualifier)

## M9L4:: Events and listeners
Main feature of events: **allowing us to write loosely coupled components that don’t have to be closely connected**.
Useful to limit dependency between beans.

**An Event is just a regular class**.
**The event listener needs to be a Spring bean. It gets notified when the event is fired**. We can have multiple
listeners registered and listening for the same event.
By default, events are entirely *synchronous* since they're sent and processed in the same thread.
**Meaning that the publish envent method blocks until all listeners finish processing the event**

***ATTENTION***: if an event type is matched by several @EventListener handlers, all handlers will be executed when event is published