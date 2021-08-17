package fa.appcode.common.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	private static Logger logger = LogManager.getLogger(Logging.class);
	
	public static Logger getLog() {
		return logger;
	}
}
