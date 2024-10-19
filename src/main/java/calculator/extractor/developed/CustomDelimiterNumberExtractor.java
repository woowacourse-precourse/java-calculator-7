package calculator.extractor.developed;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterNumberExtractor implements DelimitedNumberExtractor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    @Override
    public ExtractResult extract(String input) {
        if (!isCustomDelimiterFormat(input)) {
            return new ExtractResult(false, List.of());
        }
        String customDelimiter = extractCustomDelimiter(input);
        String numberString = extractNumberString(input);
        List<String> numbers = splitNumbers(numberString, customDelimiter);
        return new ExtractResult(true, numbers);
    }

    private boolean isCustomDelimiterFormat(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return Pattern.quote(input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex));
    }

    private String extractNumberString(String input) {
        int numberStartIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        return input.substring(numberStartIndex);
    }

    private List<String> splitNumbers(String numberString, String delimiter) {
        if (numberString.isEmpty()) {
            return List.of("0");
        }
        return Arrays.stream(numberString.split(delimiter))
                .filter(this::isNumber)
                .collect(Collectors.toList());
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

