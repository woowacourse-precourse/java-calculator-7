package calculator;

import java.util.Arrays;

public class Calculator {

    private final DelimiterHandler delimiterHandler;

    public Calculator(DelimiterHandler delimiterHandler) {
        this.delimiterHandler = delimiterHandler;
    }

    /**
     * 입력 받은 문자열을 구분자로 분리한 후 더하는 함수
     *
     * @param input 입력으로 받은 문자열
     * @return 입력으로 받은 문자열을 구분자로 분리한 후 더한 합
     */
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiterHandler.extractNumbers(input);

        return sumNumbers(numbers);
    }

    /**
     * 구분자로 분리한 숫자들을 더하는 함수
     *
     * @param numbers 구분자로 분리한 숫자로 이루어진 문자열
     * @return 숫자들의 합
     */
    private int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parseInt)
                .sum();
    }

    /**
     * 주어진 문자열을 정수로 변환하는 함수
     *
     * @param numberStr 주어진 문자열
     * @return 정수로 변환한 문자열
     */
    private int parseInt(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력 불가능합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }
}
