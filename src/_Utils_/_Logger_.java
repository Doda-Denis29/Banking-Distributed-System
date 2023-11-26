package _Utils_;

import java.util.logging.Level;
import java.util.logging.Logger;

public class _Logger_ {

    private static final Logger logger = Logger.getLogger(_Logger_.class.getName());

    public static void logDebug(String message) {
        logger.log(Level.FINE, message);
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}
