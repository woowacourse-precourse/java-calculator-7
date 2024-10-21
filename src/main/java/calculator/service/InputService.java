package calculator.service;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

	private static final int ZERO = 0;
	private static final String DEFAULT_DELIMITERS = "[,:]";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final ArrayList<String> CUSTOM_DELIMITERS = new ArrayList<>();

	public String readLine() {
		return Console.readLine();
	}

}
