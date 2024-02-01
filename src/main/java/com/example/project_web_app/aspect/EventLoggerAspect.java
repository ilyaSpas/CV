package com.example.project_web_app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EventLoggerAspect {

    @Before("com.example.project_web_app.aspect.pointcut.EventPointcut.createEventPointcut()")
    public void eventLoggerAdvice(){
        System.out.println("Попытка создания мероприятия");
    }
}
