package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService() {
        this.calculator = new Calculator();
    }

    public int calculate(String input) {
        // 3-1. 입력 문자열 전처리
        if (input == null || input.trim().isEmpty()) {
            return 0; // 빈 문자열 처리
        }

        // 3-2. 숫자 합산 로직 호출
        try {
            return calculator.sum(input);
        } catch (IllegalArgumentException e) {
            // 3-3. 예외 처리
            throw e; // 예외를 그대로 던져서 컨트롤러가 처리하도록
        }
    }
}
