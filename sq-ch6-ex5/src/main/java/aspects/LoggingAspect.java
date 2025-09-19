package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(annotations.ToLogAfterReturning)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + Collections.singletonList(returnedValue));
    }
}
