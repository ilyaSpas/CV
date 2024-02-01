package com.example.project_web_app.aspect;

import com.example.project_web_app.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
public class EventLoggerAspect {

    @Before("com.example.project_web_app.aspect.pointcut.EventPointcut.createEventPointcut()")
    public void eventLoggerAdvice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Event event = (Event) args[0];
        log.info("Попытка создания мероприя, TOWN:{} DATE:{}", event.getTown(), event.getDate());
    }
}
