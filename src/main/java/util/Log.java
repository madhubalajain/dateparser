package util;

import org.apache.log4j.Logger;

public class Log {

// Initialize Log4j logs

 //   private static Logger Log = Logger.getLogger(Log.class.getName());//

    static Logger log = Logger.getLogger("devpinoyLogger");
    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String testCaseName){


        log.info("****************************************************************************************");

        log.info("------------------               Start- "+testCaseName+ "       -----------------------");

        log.info("****************************************************************************************");


    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String testCaseName){

        log.info("****************************************************************************************");

        log.info("-------------------                End -"+testCaseName+ "       -----------------------");

        log.info("****************************************************************************************");


    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        log.info(message);

    }

    public static void warn(String message) {

        log.warn(message);

    }

    public static void error(String message) {

        log.error(message);

    }

    public static void fatal(String message) {

        log.fatal(message);

    }

    public static void debug(String message) {

        log.debug(message);

    }

}
