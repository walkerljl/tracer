package org.walkerljl.tracer.logger.defaults;

import java.text.MessageFormat;
import java.util.UUID;

import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.tracer.logger.TracerLogger;

/**
 * @author lijunlin
 */
public class DefaultTracerLogger implements TracerLogger {

    private String getTraceId() {
        return null;
    }

    public void debug(Logger logger, Object message) {

        if (logger == null) {
            return;
        }

        if (logger.isDebugEnabled()) {
            logger.debug(getLogMessageString(message));
        }
    }

    public void debug(Logger logger, String template, Object... parameters) {

        if (logger == null) {
            return;
        }

        if (logger.isDebugEnabled()) {
            logger.debug(render(template, parameters));
        }
    }

    public void info(Logger logger, Object message) {

        if (logger == null) {
            return;
        }

        if (logger.isInfoEnabled()) {
            logger.info(getLogMessageString(message));
        }
    }

    public void info(Logger logger, String template, Object... parameters) {
        if (logger == null) {
            return;
        }

        if (logger.isInfoEnabled()) {
            logger.info(render(template, parameters));
        }
    }

    public void warn(Logger logger, Object message) {

        if (logger == null) {
            return;
        }

        if (logger.isWarnEnabled()) {
            logger.warn(getLogMessageString(message));
        }
    }

    public void warn(Logger logger, String template, Object... parameters) {

        if (logger == null) {
            return;
        }

        if (logger.isWarnEnabled()) {
            logger.warn(render(template, parameters));
        }
    }

    public void warn(Logger logger, Throwable e, Object message) {

        if (logger == null) {
            return;
        }

        if (logger.isWarnEnabled()) {
            String logMessageString = String.format("%s%s%s",
                    getExceptionMessageString(e),
                    TracerLoggerConstants.LOG_SEPERATOR,
                    getLogMessageString(message));
            logger.warn(logMessageString, e);
        }
    }

    public void warn(Logger logger, Throwable e, Object message, String template, Object... parameters) {

        if (logger == null) {
            return;
        }

        String logMessageString = String.format("%s%s%s",
                getExceptionMessageString(e),
                TracerLoggerConstants.LOG_SEPERATOR,
                render(template, parameters));
        if (logger.isWarnEnabled()) {
            logger.warn(logMessageString, e);
        }
    }

    public void error(Logger logger, Throwable e) {

        if (logger == null) {
            return;
        }

        logger.error(getExceptionMessageString(e), e);
    }

    public void error(Logger logger, Throwable e, Object message) {

        if (logger == null) {
            return;
        }

        String logMessageString = String.format("%s%s%s",
                getExceptionMessageString(e),
                TracerLoggerConstants.LOG_SEPERATOR,
                getLogMessageString(message));
        logger.error(logMessageString, e);
    }

    public void error(Logger logger, Throwable e, Object message, String template, Object... parameters) {

        if (logger == null) {
            return;
        }

        String logMessageString = String.format("%s%s%s",
                getExceptionMessageString(e),
                TracerLoggerConstants.LOG_SEPERATOR,
                render(template, parameters));
        logger.error(logMessageString, e);

    }

    private String render(final String template, final Object... params) {
        if (params == null || params.length == 0) {
            return String.format("%s%s%s%s",
                    TracerLoggerConstants.LOG_PREFIX,
                    getTraceId(),
                    TracerLoggerConstants.LOG_SUFFIX,
                    template);
        }

        return String.format("%s%s%s%s",
                TracerLoggerConstants.LOG_PREFIX,
                getTraceId(),
                TracerLoggerConstants.LOG_SUFFIX,
                MessageFormat.format(template, params));
    }

    private String getLogMessageString(Object message) {
        StringBuilder logMessageString = new StringBuilder();

        logMessageString.append(TracerLoggerConstants.LOG_PREFIX);
        logMessageString.append(message);

        // 加入日志流水号
        logMessageString.append(getSerialNumber());

        logMessageString.append(TracerLoggerConstants.LOG_SUFFIX);

        return logMessageString.toString();
    }

    private String getExceptionMessageString(Throwable e) {
        return (e == null ? "" : e.getMessage());
    }

    private String getSerialNumber() {

        StringBuilder serialNumber = new StringBuilder();

        serialNumber.append(TracerLoggerConstants.LOG_PARAM_PREFIX);
        serialNumber.append(UUID.randomUUID().toString().replaceAll("-", ""));
        serialNumber.append(TracerLoggerConstants.LOG_PARAM_SUFFIX);

        return serialNumber.toString();
    }

}