package calculator.domain;

import calculator.service.CalculatorService;

/**
 * 문자열로 표현된 수식을 계산하는 계산기
 */

public class StringCalculator {
    private final CalculatorService service;

    public StringCalculator() {
        this.service = new CalculatorService();
    }

    public Number calculate(String input) {
        System.out.println("StringCalculator - 계산 시작. 입력 문자열: '" + input + "'");
        try {
            Number result = service.calculate(input);
            System.out.println("StringCalculator - 계산 완료. 결과: " + result.value());
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("StringCalculator - 계산 중 오류 발생: " + e.getMessage());
            throw e;
        }
    }
}