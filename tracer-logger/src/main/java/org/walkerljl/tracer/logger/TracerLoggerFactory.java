package org.walkerljl.tracer.logger;

import org.walkerljl.tracer.logger.defaults.DefaultTracerLogger;

/**
 *
 * @author lijunlin
 */
public class TracerLoggerFactory {

    public static TracerLogger getTracerLogger(Class<? extends TracerLogger> tracerLoggerClass) {

        if (tracerLoggerClass == DefaultTracerLogger.class) {
            return new DefaultTracerLogger();
        } else {
            return new DefaultTracerLogger();
        }
    }
}