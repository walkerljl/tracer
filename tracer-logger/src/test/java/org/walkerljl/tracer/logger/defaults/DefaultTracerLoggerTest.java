package org.walkerljl.tracer.logger.defaults;

import org.junit.Before;
import org.junit.Test;
import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.tracer.logger.BaseUnitTest;
import org.walkerljl.tracer.logger.TracerLogger;

/**
 * @author lijunlin
 */
public class DefaultTracerLoggerTest extends BaseUnitTest {

    private static Logger LOGGER = null;
    private TracerLogger tracerLogger = new DefaultTracerLogger();

    @Before
    public void before() {
        LOGGER = LoggerFactory.getLogger(DefaultTracerLoggerTest.class);
    }

    @Test
    public void debug() {

        tracerLogger.debug(LOGGER, "Do log.");
        tracerLogger.debug(LOGGER, "userId=lijunlin");
        tracerLogger.debug(LOGGER, "userId={0}", "lijunlin");
    }


    @Test
    public void info() {

        tracerLogger.info(LOGGER, "Do log.");
        tracerLogger.info(LOGGER, "userId=lijunlin");
        tracerLogger.info(LOGGER, "userId={0}", "lijunlin");
    }


    @Test
    public void warn() {

        tracerLogger.warn(LOGGER, "Do log.");
        tracerLogger.warn(LOGGER, "userId=lijunlin");
        tracerLogger.warn(LOGGER, "userId={0}", "lijunlin");

        Throwable throwable = new RuntimeException("An exception");
        tracerLogger.warn(LOGGER, throwable, "Do log.");
        tracerLogger.warn(LOGGER, throwable, "userId=lijunlin");
        tracerLogger.warn(LOGGER, throwable, "userId={0}", "lijunlin");

    }

    @Test
    public void error() {

        Throwable throwable = new RuntimeException("An exception");
        tracerLogger.error(LOGGER, throwable);

        tracerLogger.error(LOGGER, throwable, "Do log.");
        tracerLogger.error(LOGGER, throwable, "userId=lijunlin");
        tracerLogger.error(LOGGER, throwable, "userId={0}", "lijunlin");

    }
}