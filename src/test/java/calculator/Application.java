package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String NEW_LINE = "\n";
    private static final String DEFAULT_SEPARATOR = "[,;]";

    StringCalculator calculator = new Application().new StringCalculator();

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = new Application().calculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public class StringCalculator {

        public int calculate(String input) {
            if (isBlankOrNull(input)) {
                return 0;
            }

            String[] numbers = parseNumbers(input);
            return sum(numbers);
        }

        private boolean isBlankOrNull(String input) {
            return input == null || input.trim().isEmpty();
        }

        private String[] parseNumbers(String input) {
            if (hasCustomSeparator(input)) {
                return parseWithCustomSeparator(input);
            }
            return input.split(DEFAULT_SEPARATOR);
        }

        private boolean hasCustomSeparator(String input) {
            return input.startsWith(CUSTOM_SEPARATOR_PREFIX);
        }

        private String[] parseWithCustomSeparator(String input) {
            String delimiter = extractCustomSeparator(input);
            String numbersString = extractNumbersString(input);
            return numbersString.split(delimiter);
        }

        private String extractCustomSeparator(String input) {
            int delimiterStart = CUSTOM_SEPARATOR_PREFIX.length();
            int delimiterEnd = input.indexOf(NEW_LINE);
            return Pattern.quote(input.substring(delimiterStart, delimiterEnd));
        }

        private String extractNumbersString(String input) {
            int numbersStart = input.indexOf(NEW_LINE) + 1;
            return input.substring(numbersStart);
        }

        private int sum(String[] numbers) {
            return Arrays.stream(numbers)
                    .map(this::parseNumber)
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        private int parseNumber(String number) {
            int value = Integer.parseInt(number.trim());
            validateNonNegative(value);
            return value;
        }

        private void validateNonNegative(int number) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }
    }

}