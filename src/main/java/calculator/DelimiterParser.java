package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String VALID_CUSTOM_DELIMITER_FORMAT = "//(?<customDelimiter>.)\\\\n(?<input>.+)";
    private static final String VALID_INPUT_FORMAT_TEMPLATE = "^[1-9][0-9]*(%s[1-9][0-9]*)*$";
    private static final String COMBINED_DELIMITER_TEMPLATE = "[,:%s]";
    private static final String ERROR_MESSAGE = "양수와 구분자로 이루어진 문자열을 입력하세요.";

    private static class CustomDelimiterInput {
        final String customDelimiter;
        final String strToAdd;

        public CustomDelimiterInput(String input) {
            Pattern validCustomDelimiterPattern = Pattern.compile(VALID_CUSTOM_DELIMITER_FORMAT);
            Matcher matcher = validCustomDelimiterPattern.matcher(input);

            if (!matcher.find()) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }

            this.customDelimiter = matcher.group("customDelimiter");
            this.strToAdd = matcher.group("input");
        }
    }

    public String[] parse(String input) {
        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }

        return parseWithDefaultDelimiter(input);
    }

    private String[] parseWithCustomDelimiter(String input) {
        CustomDelimiterInput customDelimiterInput = new CustomDelimiterInput(input);
        String customDelimiter = customDelimiterInput.customDelimiter;
        String strToAdd = customDelimiterInput.strToAdd;

        String combinedDelimiter = String.format(COMBINED_DELIMITER_TEMPLATE, customDelimiter);
        if (isInvalidInputFormat(strToAdd, String.format(VALID_INPUT_FORMAT_TEMPLATE, combinedDelimiter))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return Pattern.compile(combinedDelimiter).split(strToAdd);
    }

    private String[] parseWithDefaultDelimiter(String input) {
        if (isInvalidInputFormat(input, String.format(VALID_INPUT_FORMAT_TEMPLATE, DEFAULT_DELIMITER))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return Pattern.compile(DEFAULT_DELIMITER).split(input);
    }

    private boolean isInvalidInputFormat(String strToAdd, String validInputFormat) {
        return !Pattern.matches(validInputFormat, strToAdd);
    }
}