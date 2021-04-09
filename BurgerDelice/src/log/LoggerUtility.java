package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Utility class used to generate Log4j logger.
 * 
 * We can generate logs in a text file.
 * 
 * @author Zacharie
 */
public class LoggerUtility {
	private static final String PROCESS_LOG_CONFIG = "BurgerDelice\\src\\log\\log4j-process.properties";
	private static final String GUI_LOG_CONFIG = "BurgerDelice\\src\\log\\log4j-gui.properties";

	public static Logger getLogger(Class<?> logClass, String logFileType) {
		if (logFileType.equals("process")) {
			PropertyConfigurator.configure(PROCESS_LOG_CONFIG);
		} else if (logFileType.equals("gui")) {
			PropertyConfigurator.configure(GUI_LOG_CONFIG);
		} else {
			throw new IllegalArgumentException("Unknown log file type !");
		}

		String className = logClass.getName();
		return Logger.getLogger(className);
	}
}
