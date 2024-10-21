package calculator.service;

import static calculator.constant.ExceptionMessage.CUSTOM_DELIMITER_POSITION;
import static calculator.constant.ExceptionMessage.INVALID_CUSTOM_DELIMITER_FORMAT;

import calculator.dto.ExtractionResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
    private static final String CUSTOM_DELIMITER_PATTERN =
            CUSTOM_DELIMITER_PREFIX + "((?:(?!" + CUSTOM_DELIMITER_SUFFIX + ").)+)" + CUSTOM_DELIMITER_SUFFIX;
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public ExtractionResult extract(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            validateNoCustomDelimiterInMiddle(input);
            return ExtractionResult.of(new ArrayList<>(), input);
        }

        return handleInputWithCustomDelimiter(input);
    }

    private ExtractionResult handleInputWithCustomDelimiter(String input) {
        List<String> customDelimiters = new ArrayList<>();
        String remainingInput = input;

        while (remainingInput.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            Matcher matcher = PATTERN.matcher(remainingInput);
            if (!matcher.find()) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.message());
            }

            customDelimiters.add(matcher.group(1));
            remainingInput = remainingInput.substring(matcher.end());
        }

        validateNoCustomDelimiterInMiddle(remainingInput);

        return ExtractionResult.of(customDelimiters, remainingInput);
    }

    private void validateNoCustomDelimiterInMiddle(String input) {
        if (PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_POSITION.message());
        }
    }
}