package org.walkerljl.tracer.logger;

import org.junit.Test;
import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.tracer.logger.defaults.DefaultTracerLogger;

/**
 * @author lijunlin
 */
public class TracerLoggerFactoryTest extends BaseUnitTest {

    @Test
    public void getTraceLogger() {

        Logger logger = LoggerFactory.getLogger(TracerLoggerFactoryTest.class);

        TracerLogger tracerLogger = TracerLoggerFactory.getTracerLogger(DefaultTracerLogger.class);
        tracerLogger.info(logger, "Record some log messages.");
    }
}