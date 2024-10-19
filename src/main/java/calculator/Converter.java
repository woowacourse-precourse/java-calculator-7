package calculator;

import java.util.regex.Pattern;

public class Converter {

    private static final String SEPARATOR = "[,:]";
    private final InputValidator inputValidator = new InputValidator();

    public String[] toStringArr(String input) {

        if (inputValidator.isCustomPattern(input)) {
            String customPattern = String.valueOf(input.charAt(2));
            String numbers = input.substring(5);

            inputValidator.isInvalidFormatCustomPattern(customPattern, numbers);

            String customDelimiter = Pattern.quote(customPattern); // 특수문자 처리

            return numbers.split(customDelimiter);
        }

        inputValidator.isInvalidFormat(input);

        return input.split(SEPARATOR);
    }



}
