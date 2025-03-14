package com.learningByDoing.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("com.learningByDoing.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.learningByDoing.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer
        long startTimeInMillis = System.currentTimeMillis();

        //Execute the Method
        Object returnValue = proceedingJoinPoint.proceed();

        //Stop the timer
        long stopTimeInMillis = System.currentTimeMillis();

        long executionDuration = stopTimeInMillis - startTimeInMillis;

        logger.info("Around Aspect - {} Method executed in {}ms", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
