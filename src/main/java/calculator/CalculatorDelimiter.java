package calculator;

import java.util.regex.Pattern;

public class CalculatorDelimiter {
    static final String DEFAULT_DELIMITER = ",|:";
    static final String DEFINE_CUSTOM_DELIMITER_HEAD = "//";
    static final String DEFINE_CUSTOM_DELIMITER_LAST = "\n";
    static final Integer DEFINE_CUSTOM_DELIMITER_LAST_SIZE = 2;
    static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\n(.*)");
    static final Pattern CONTAINS_NUMBERS_PATTERN = Pattern.compile(".*\\d+.*");
    static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("^[0-9,:,\\s]*$");

}
