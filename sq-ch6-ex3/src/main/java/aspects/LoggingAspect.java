package aspects;

import models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("Method " + methodName + " with parameters " + Arrays.asList(methodArgs) + " will execute");

        Comment comment = new Comment("Altering parameters and returned value using AOP", "hula@nm0");

        Object returnedByMethod = joinPoint.proceed(new Object[]{comment});

        logger.info("Method executed and returned " + returnedByMethod);

        return "FAILED";
    }
}
