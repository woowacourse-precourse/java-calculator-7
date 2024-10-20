package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    private int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        InputParser parser = InputParser.from(input);
        return Stream.of(parser.split())
                .peek(this::validateNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void validateNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다: " + number);
        }
    }

    private record InputParser(String text, String delimiter) {

        public String[] split() {
            return text.split(delimiter);
        }

        public static InputParser from(String input) {
            if (!hasCustomDelimiter(input)) {
                return new InputParser(input, DEFAULT_DELIMITERS);
            }
            return parseCustomDelimiter(input);
        }

        private static boolean hasCustomDelimiter(String input) {
            return input.length() >= 5 && input.startsWith(CUSTOM_DELIMITER_PREFIX);
        }

        private static InputParser parseCustomDelimiter(String input) {
            int suffixIndex = getSuffixIndex(input);
            String customDelimiter = extractCustomDelimiter(input, suffixIndex);
            validateCustomDelimiter(customDelimiter);
            return createDelimiterInfo(input, suffixIndex, customDelimiter);
        }

        private static int getSuffixIndex(String input) {
            int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (suffixIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            return suffixIndex;
        }

        private static String extractCustomDelimiter(String input, int suffixIndex) {
            return input.substring(CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
        }

        private static void validateCustomDelimiter(String delimiter) {
            if (delimiter.length() != 1 || Character.isDigit(delimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 한 글자여야 합니다.");
            }
        }

        private static InputParser createDelimiterInfo(String input, int suffixIndex, String customDelimiter) {
            String numberPart = input.substring(suffixIndex + CUSTOM_DELIMITER_SUFFIX.length());
            String combinedDelimiter = String.format("[%s,:]", customDelimiter);
            return new InputParser(numberPart, combinedDelimiter);
        }

    }
}
