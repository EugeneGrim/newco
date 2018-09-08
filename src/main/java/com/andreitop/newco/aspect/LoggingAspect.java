package com.andreitop.newco.aspect;


import com.andreitop.newco.dto.TripDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @Around("com.andreitop.newco.aspect.PointcutContainer.serviceMethods()")
    public Object loggingServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Service method " + className + "." + methodName + " is about to be called");
        Object proceed = joinPoint.proceed();
        logger.info(" ---> Service method " + className + "." + methodName + " has called");
        return proceed;
    }

    @After("com.andreitop.newco.aspect.PointcutContainer.controllerMethodsWithTripDtoArg()")
    public void loggingControllerMethodsWithTripDtoArg(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        TripDto arg = (TripDto) joinPoint.getArgs()[0];
        logger.info(" ---> Controller method " + className + "." + methodName +
                " with TripDto argument (id = " + arg.getId() + ") has called");
    }
}
