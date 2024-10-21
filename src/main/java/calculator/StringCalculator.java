package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int calculate(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 구분자 전략 설정 (커스텀 구분자 또는 기본 구분자)
        DelimiterStrategy delimiterStrategy = DelimiterStrategyFactory.create(input);

        // 구분자로 문자열 분리하기
        List<String> tokens = delimiterStrategy.split(input);

        // 숫자 검증 및 덧셈 계산
        List<Integer> numbers = validateAndParseNumbers(tokens);
        return sum(numbers);
    }

    private List<Integer> validateAndParseNumbers(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + token);
            }
        }
        return numbers;
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
