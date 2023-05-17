package ru.bstu.akudrenko.tests;

import org.apache.logging.log4j.Logger;

public abstract class Demo {
    protected final Logger logger;

    public Demo(Logger logger) {
        this.logger = logger;
    }

    public void run() {
        String className = getClass().getSimpleName();
        logger.debug(String.format("Demo `%s` has started", className));

        try {
            demo();
            logger.debug(String.format("Demo `%s` successfully done", className));
        } catch (Exception e) {
            logger.error(String.format("Demo `%s` failed with error. Message: \"%s\"", className, e.getMessage()));
            throw e;
        }
    }

    protected abstract void demo();

    protected void logIncorrectNumberInputWarn() {
        logger.warn("Getting number from input stream failed. Incorrect value replaced with default value");
    }
}
