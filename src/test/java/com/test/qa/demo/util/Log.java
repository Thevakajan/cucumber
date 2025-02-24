package com.test.qa.demo.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);

    public static void startTestCase() {
        logger.log(Level.INFO, "****************************************");
        logger.log(Level.INFO, "************** start test case *************");
        logger.log(Level.INFO, "****************************************");
    }

    public static void endTestCase() {
        logger.log(Level.INFO, "****************************************");
        logger.log(Level.INFO, "************** end test case *************");
        logger.log(Level.INFO, "****************************************");
    }
}
