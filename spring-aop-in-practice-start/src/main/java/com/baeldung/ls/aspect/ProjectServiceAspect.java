package com.baeldung.ls.aspect;

import com.baeldung.ls.persistence.model.Project;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class ProjectServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    /**
     * Value inside Before is the predicate matching the joinpoint => the Point cut
     * => The join point here is the findById method
     * @Before is an advice that runs the aspect before the joinpoint (i.e method) itself runs
     **/
    @Before("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        // This method body is an aspect (actual cross-cutting logic)
        // joinPoint.getArgs() is an array of findById method arguments
        LOG.info("Before advice - Searching Project with Id {}", joinPoint.getArgs()[0]);
    }

    /**
     * The point cut here matches all methods named findById in the service package
     * @param project : equals param in returning attribute
     */
    @AfterReturning(pointcut = "execution(*..Optional<*..Project> *..service..findById(*))", returning = "project")
    public void afterReturningProject(Optional<Project> project) {
        LOG.info("AfterReturning advice - project found: {}", project.orElse(null));
    }

    @After("within(com.baeldung.ls.service.impl.ProjectServiceImpl)")
    public void afterAllMethodsOfProjectServiceImpl(JoinPoint joinPoint) {
        LOG.info("After advice - After Invoking the method: {} ", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "within(com.baeldung.ls.service.impl.ProjectServiceImpl)", throwing = "exception")
    public void afterErrorsInAllMethodsOfProjectServiceImpl(JoinPoint joinPoint, Throwable exception) {
        LOG.error(String.format("AfterThrowing advice - After Invoking the method: %s ", joinPoint.getSignature().getName()), exception);
    }

    @Around("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.save(*))")
    public Object aroundSave(ProceedingJoinPoint joinPoint) {
        Object val = joinPoint.getArgs()[0];
        try {
            LOG.info("saving project : {}", val);
            val = joinPoint.proceed();
            LOG.info("project saved successfully !!");
        } catch (Throwable e) {
            LOG.error("error while saving project: ", e);
        }
        return val;
    }





}
