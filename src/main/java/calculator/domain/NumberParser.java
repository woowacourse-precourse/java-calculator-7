package calculator.domain;

import java.util.Arrays;

public class NumberParser {
    private final DelimiterExtractor delimiterExtractor;

    public NumberParser() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public String[] parse(String input) {
        String[] extractedData = delimiterExtractor.extract(input);
        String delimiter = extractedData[0];
        String numbers = extractedData[1];

        Validator.validateNotEmpty(numbers);

        String[] numberArray = numbers.split(delimiter);
        Validator.validateNumbers(numberArray);

        return numberArray;
    }

    /* Validator */
    private static class Validator {
        static boolean isBlank(String str) {
            return str == null || str.trim().isEmpty();
        }

        static void validateNotEmpty(String str) {
            if (isBlank(str)) {
                throw new IllegalArgumentException("비어있는 숫자가 입력되었습니다.");
            }
        }

        static void validateNumbers(String[] numbers) {
            Arrays.stream(numbers).forEach(number -> {
                if (!isNumeric(number)) {
                    throw new IllegalArgumentException("숫자가 아닌 잘못된 입력입니다: " + number);
                }
                if (Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
            });
        }

        private static boolean isNumeric(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
