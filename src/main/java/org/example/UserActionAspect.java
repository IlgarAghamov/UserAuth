package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class UserActionAspect {

    private static final Logger logger = Logger.getLogger(UserActionAspect.class.getName());

    @Pointcut("@annotation(TrackUserAction)")
    public void trackUserAction() {}

    @AfterReturning(pointcut = "trackUserAction()", returning = "result")
    public void logUserAction(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        String arguments = Arrays.toString(args);

        logger.info("User action: Method " + methodName + " of class " + className + " called with arguments " + arguments + " and returned " + result);
    }
}
