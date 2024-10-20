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
        InputParser parser = InputParser.from(input);
        return Stream.of(parser.split())
                .mapToInt(Integer::parseInt)
                .sum();
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
            int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
            String numberPart = input.substring(suffixIndex + CUSTOM_DELIMITER_SUFFIX.length());
            String combinedDelimiter = String.format("[%s,:]", customDelimiter);

            return new InputParser(numberPart, combinedDelimiter);
        }
    }
}
