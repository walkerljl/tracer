package org.walkerljl.tracer.logger;

import org.walkerljl.toolkit.logging.Logger;

/**
 * @author lijunlin
 */
public interface TracerLogger {

    void debug(Logger logger, Object message);

    void debug(Logger logger, String template, Object... parameters);

    void info(Logger logger, Object message);

    void info(Logger logger, String template, Object... parameters);

    void warn(Logger logger, Object message);

    void warn(Logger logger, String template, Object... parameters);

    void warn(Logger logger, Throwable e, Object message);

    void warn(Logger logger, Throwable e, Object message, String template, Object... parameters);

    void error(Logger logger, Throwable e);

    void error(Logger logger, Throwable e, Object message);

    void error(Logger logger, Throwable e, Object message, String template, Object... parameters);
}