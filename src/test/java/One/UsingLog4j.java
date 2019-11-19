package One;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UsingLog4j {

    private static Logger logger = Logger.getLogger(UsingLog4j.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
    }
}
