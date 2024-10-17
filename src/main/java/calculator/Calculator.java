package calculator;

import java.util.List;

public class Calculator {

    private final String input;
    private final Validator validator = new Validator();
    private final Delimiter delimiter = new Delimiter();
    private final Converter converter = new Converter();

    public Calculator(String input) {
        this.input = input;
    }

    /**
     * 숫자의 합 계산
     */
    public int add(String input) {
        // 빈 입력 처리 (빈 문자열, 엔터, 탭, null)
        if (validator.isEmpty(input)) {
            return 0;
        }

        // 단일 숫자 입력 처리
        if (validator.isInteger(input)) {
            return Integer.parseInt(input);
        }

        // 음수 입력 예외 처리
        validator.isNegative(input);

        // 기본 구분자(쉼표, 콜론) 처리
        if (input.contains(",") || input.contains(":")) {
            String[] tokens = delimiter.defaultDelimiter(input);
            List<Integer> numbers = converter.convertToNumbers(tokens);
            return sum(numbers);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            String[] tokens = delimiter.customDelimiter(input);
            List<Integer> numbers = converter.convertToNumbers(tokens);
            return sum(numbers);
        }

        throw new IllegalArgumentException();
    }

    /**
     * 숫자들의 합을 구하는 메서드
     */
    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
