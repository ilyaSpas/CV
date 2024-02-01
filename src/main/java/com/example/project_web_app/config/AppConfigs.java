package com.example.project_web_app.config;

import com.example.project_web_app.aspect.EventLoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfigs {
    @Bean
    public EventLoggerAspect eventLoggerAspect(){
        return new EventLoggerAspect();
    }
}
