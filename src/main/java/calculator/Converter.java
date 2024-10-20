package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Converter {

    private static final String DEFAULT_SEPARATORS = "[,:]";
    private final InputValidator inputValidator = new InputValidator();

    public String[] toStringArr(String input) {
        String separator = DEFAULT_SEPARATORS;

        if (inputValidator.isCustomPattern(input)) {
            String customPattern = String.valueOf(input.charAt(2));
            input = input.substring(5);

            separator = Pattern.quote(customPattern); // 특수문자 처리
        }

        return Arrays.stream(input.split(separator))
                .peek(inputValidator::isInvalidNumber)
                .toArray(String[]::new);
    }
}
