package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void serviceMethods() {
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controllerMethods() {
    }

    @Pointcut("args(com.andreitop.newco.dto.TripDto)")
    public void methodsWithTripDtoArg() {
    }

    @Pointcut("controllerMethods() && methodsWithTripDtoArg()")
    public void controllerMethodsWithTripDtoArg() {
    }
}
