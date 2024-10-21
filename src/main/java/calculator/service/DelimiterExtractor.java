package calculator.service;

import static calculator.constant.ExceptionMessage.CUSTOM_DELIMITER_POSITION;
import static calculator.constant.ExceptionMessage.INVALID_CUSTOM_DELIMITER_FORMAT;

import calculator.dto.ExtractionResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String CUSTOM_DELIMITER_PATTERN = "//((?:(?!\\\\n).)+)\\\\n";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
    public static final String CUSTOM_DELIMITER_PREFIX = "//";

    public ExtractionResult extract(String input) {
        List<String> customDelimiters = new ArrayList<>();

        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            if (PATTERN.matcher(input).find()) {
                throw new IllegalArgumentException(CUSTOM_DELIMITER_POSITION.message());
            }
            return ExtractionResult.of(customDelimiters, input);
        }

        String remainingInput = input;

        do {
            Matcher matcher = PATTERN.matcher(remainingInput);
            if (!matcher.find()) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.message());
            }

            String customDelimiter = matcher.group(1);
            customDelimiters.add(customDelimiter);
            remainingInput = remainingInput.substring(matcher.end());

        } while (remainingInput.startsWith(CUSTOM_DELIMITER_PREFIX));

        if (PATTERN.matcher(remainingInput).find()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_POSITION.message());
        }

        return ExtractionResult.of(customDelimiters, remainingInput);
    }
}