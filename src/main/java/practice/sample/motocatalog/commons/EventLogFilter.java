package practice.sample.motocatalog.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class EventLogFilter {
    
    @Before("execution(* practice.sample.motocatalog..*Controller.*(..))")
    public void beforeLog(JoinPoint joinPoint) {
        //Contoroller処理の呼び出し前
        log.info(String.format("%s START", joinPoint.toShortString()));
    }

    @After("execution(* practice.sample.motocatalog..*Controller.*(..))")
    public void afterLog(JoinPoint joinPoint) {
        //Contoroller処理の呼び出し後
        log.info(String.format("%s END", joinPoint.toShortString()));
    }
}
