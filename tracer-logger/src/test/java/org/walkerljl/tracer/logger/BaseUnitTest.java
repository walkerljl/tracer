package org.walkerljl.tracer.logger;

import org.junit.After;
import org.junit.Before;

/**
 *
 * @author lijunlin
 */
public abstract class BaseUnitTest {

    @Before
    public void before() {
        System.setProperty("org.walkerljl.logging", "log4j");
    }

    @After
    public void after() {

    }


}