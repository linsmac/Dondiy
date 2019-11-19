import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
    public static void main(String[] args) {

        Logger loggerA = LogManager.getLogger("RollingRandomAccessFileLogger");
        for(int i = 0; i < 50000; i++  ) {
            loggerA.trace("trace level");
            loggerA.debug("debug level");
            loggerA.info("info level");
            loggerA.warn("warn level");
            loggerA.error("error level");
            loggerA.fatal("fatal level");
        }
    }
}
