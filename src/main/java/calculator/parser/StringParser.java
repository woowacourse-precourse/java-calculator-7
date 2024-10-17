package calculator.parser;


import calculator.validator.InputValidator;

public class StringParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELEMITER_PREFIX = "//";
    private static final String CUSTOM_DELEMITER_SUFFIX = "\\n";

    public static ParseResult parse(String input) {
        InputValidator.validateInput(input);

        if (input.startsWith(CUSTOM_DELEMITER_PREFIX)) {
            return parseWithCustomDelimiter(input);
        }else{
            return parseWithDefaultDelimiter(input);
        }
    }

    private static ParseResult parseWithDefaultDelimiter(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITERS);
        return new ParseResult(numbers, DEFAULT_DELIMITERS);
    }

    private static ParseResult parseWithCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf(CUSTOM_DELEMITER_SUFFIX);
        String customDelimiter = findCustomDelimiter(input, delimiterEnd);
        String delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
        String numberString = findNumberString(input, delimiterEnd);
        String[] numbers = numberString.split(delimiters);
        return new ParseResult(numbers, delimiters);
    }

    private static String findCustomDelimiter(String input, int delimiterEnd){
        return input.substring(CUSTOM_DELEMITER_PREFIX.length(), delimiterEnd);
    }

    private static String findNumberString(String input, int delimiterEnd) {
        return input.substring(CUSTOM_DELEMITER_SUFFIX.length() + delimiterEnd);
    }

}
