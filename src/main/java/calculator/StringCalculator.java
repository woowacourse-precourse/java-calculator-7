package calculator;

import java.util.List;

public class StringCalculator {

    private final List<DelimiterStrategy> strategies;

    // 의존성 주입을 통해 구분자 처리 전략을 설정 (DIP)
    public StringCalculator(List<DelimiterStrategy> strategies) {
        this.strategies = strategies;
    }

    // 계산을 시작하는 메서드
    public int start(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 적합한 구분자 전략 찾기
        for (DelimiterStrategy strategy : strategies) {
            if (strategy.supports(input)) {
                String[] factors = strategy.split(input);
                return sum(factors);
            }
        }

        throw new IllegalArgumentException("유효한 구분자 전략이 없습니다.");
    }

    // 숫자 합산 로직 (SRP)
    private int sum(String[] factors) {
        int sum = 0;
        for (String factor : factors) {
            try {
                int number = Integer.parseInt(factor.trim());
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        return sum;
    }

}
