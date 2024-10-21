package calculator.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";


    public List<BigDecimal> parse(String input) {
        String[] splitInput;
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            splitInput = splitByCustomDelimiter(input);
        } else {
            splitInput = input.split(DEFAULT_DELIMITER_REGEX);
        }

        return convertToNumbers(splitInput);
    }

    private List<BigDecimal> convertToNumbers(String[] splitInput) {
        try {
            return Arrays.stream(splitInput)
                    .map(String::trim)
                    .map(BigDecimal::new)
                    .peek(number -> {
                        if (number.signum() == -1) {
                            throw new IllegalArgumentException("음수 값이 포함되어 있습니다: " + number);
                        }
                    })
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private String[] splitByCustomDelimiter(String input) {
        int delimiterEndIdx = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEndIdx == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식 오류입니다.");
        }

        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIdx);
        customDelimiter = Pattern.quote(customDelimiter);

        String numberPart = input.substring(delimiterEndIdx + CUSTOM_DELIMITER_SUFFIX.length());

        return numberPart.split(DEFAULT_DELIMITER_REGEX + '|' + customDelimiter);
    }
}
