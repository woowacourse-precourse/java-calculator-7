package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";
    private static final String DEFAULT_SEPARATOR = "[,;]";

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static class StringCalculator {

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
            if (input.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
                String separator = extractCustomSeparator(input);
                String numberString = extractNumbersString(input);
                return numberString.split(separator);
            }
            return input.split(DEFAULT_SEPARATOR);
        }

        private String extractCustomSeparator(String input) {
            int separatorStart = CUSTOM_SEPARATOR_PREFIX.length();
            int separatorEnd = input.indexOf(CUSTOM_SEPARATOR_SUFFIX);
            return Pattern.quote(input.substring(separatorStart, separatorEnd));
        }

        private String extractNumbersString(String input) {
            int numbersStart = input.indexOf(CUSTOM_SEPARATOR_SUFFIX) + 1;
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
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return value;
        }
    }
}