package com.example.project_web_app.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class EventPointcut {
    @Pointcut("execution(* com.example.project_web_app.service.EventService.create(..))")
    public void createEventPointcut(){}
}
