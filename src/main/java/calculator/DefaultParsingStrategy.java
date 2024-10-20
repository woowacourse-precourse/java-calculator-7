package calculator;

import java.util.Arrays;

public class DefaultParsingStrategy implements ParsingStrategy {
    private static final String NUMBER_PATTERN = "-?\\d+"; // 숫자와 부호 패턴
    private static final String DELIMITERS = ",|:"; // 구분자

    @Override
    public int parse(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(DELIMITERS);
        return Arrays.stream(numbers)
                .mapToInt(this::convertToInt)
                .sum();
    }

    private int convertToInt(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        validateNumber(number);
        int num = Integer.parseInt(number);
        validateNonNegative(num);
        return num;
    }

    private void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 문자 입력: " + number);
        }
    }

    private void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다: " + number);
        }
    }
}
