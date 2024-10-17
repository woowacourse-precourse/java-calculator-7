package calculator.util;

import java.util.logging.Logger;

public class LoggerFactory {
	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz.getName());
	}
}
