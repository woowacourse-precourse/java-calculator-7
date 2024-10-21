package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String PREFIX_CUSTOM_DELIMITER = "//";
	private static final String SUFFIX_CUSTOM_DELIMITER = "\\n";

	private static final Pattern pattern = java.util.regex.Pattern.compile("//(.*?)\\\\n");
	private static final String DEFAULT_PATTERN = "[,:]";

	public static String readInput() {
		return Console.readLine();
	}
}
