package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DigitParser {

    private static final String BASIC_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_START_COMMAND = "//";
    private static final String CUSTOM_DELIMITER_END_COMMAND = "\\n";

    /**
     * 입력된 문자 내에서 특정 구분자를 단위로 숫자를 추출하여 리스트로 반환합니다.
     *
     * @param input 숫자가 포함된 문자열
     * @return 숫자 리스트
     */
    public List<Integer> parse(String input) {
        StringTokenizer tokenizer = createTokenizer(input);
        List<Integer> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            try {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                numbers.add(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력 값이 포함되었습니다.");
            }
        }
        return numbers;
    }

    private StringTokenizer createTokenizer(String input) {
        input = input.trim();

        if (hasCustomDelimiter(input)) {
            String delimiter = createCustomDelimiter(input);
            String newInput = input.substring(
                input.indexOf(CUSTOM_DELIMITER_END_COMMAND) + CUSTOM_DELIMITER_END_COMMAND.length());

            return new StringTokenizer(newInput, delimiter);
        }

        return new StringTokenizer(input, BASIC_DELIMITER_PATTERN);
    }

    public static void validateInput(String input) {
        String regex = "^(//|\\d|;|:)";

        if(input == null || !input.matches(regex)) {
            throw new IllegalArgumentException("잘못된 입력 값이 포함되었습니다.");
        }
    }

    private static boolean hasCustomDelimiter(String input) {
        int startIdx = input.indexOf(CUSTOM_DELIMITER_START_COMMAND);
        int endIdx = input.indexOf(CUSTOM_DELIMITER_END_COMMAND);
        return startIdx == 0 && endIdx > 0;
    }

    private static String createCustomDelimiter(String input) {
        int startIdx = input.indexOf(CUSTOM_DELIMITER_START_COMMAND);
        int endIdx = input.indexOf(CUSTOM_DELIMITER_END_COMMAND);
        return input.substring(startIdx + CUSTOM_DELIMITER_START_COMMAND.length(), endIdx);
    }

}
