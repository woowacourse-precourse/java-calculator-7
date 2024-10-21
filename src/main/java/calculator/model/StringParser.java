package calculator.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";


    public List<BigDecimal> parse(String input) {
        String[] splitInput = input.split(DEFAULT_DELIMITER_REGEX);
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
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");   // TODO
        }
    }
}
