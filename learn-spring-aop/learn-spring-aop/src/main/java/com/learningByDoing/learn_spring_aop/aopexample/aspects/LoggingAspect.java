package com.learningByDoing.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    // execution(* package com.learningByDoing.learn_spring_aop.aopexample.business.*.*(..))
    @Before("execution(* com.learningByDoing.learn_spring_aop.aopexample.*.*.*(..))") // WHEN to do
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
//            logger.info("Before Aspect -  Method is called - {}", joinPoint); // WHAT to do
        logger.info("Before Aspect -  Method is called - {}", joinPoint, joinPoint.getArgs()); // WHAT to do
         // Before Aspect -  Method is called -
        // execution(int com.learningByDoing.learn_spring_aop.aopexample.business.BusinessService1.calculateMax())
    }

    @After("execution(* com.learningByDoing.learn_spring_aop.aopexample.*.*.*(..))") // WHEN to do
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
//      logger.info("After Aspect -  Method is called - {}", joinPoint); // WHAT to do
        logger.info("After Aspect -  Method is called - {}", joinPoint, joinPoint.getArgs()); // WHAT to do
    }

    @AfterThrowing(pointcut = "execution(* com.learningByDoing.learn_spring_aop.aopexample.*.*.*(..))",
                    throwing="exception") // WHEN to do
    public void logMethodCallAfterThrowingException(JoinPoint joinPoint, Exception exception){
//      logger.info("AfterThrowing Aspect -  {} - has thrown exception", joinPoint); // WHAT to do
        logger.info("AfterThrowing Aspect -  {} - has thrown exception", joinPoint, exception); // WHAT to do
    }

    @AfterReturning(pointcut = "execution(* com.learningByDoing.learn_spring_aop.aopexample.*.*.*(..))",
            returning = "resultValue") // WHEN to do
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){
        logger.info("AfterReturning Aspect -  {} - has returned {}", joinPoint, resultValue); // WHAT to do
    }
}
