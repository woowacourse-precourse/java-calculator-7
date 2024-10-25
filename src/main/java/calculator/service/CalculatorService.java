package calculator.service;

import calculator.model.Calculator;
import calculator.model.DelimiterParser;
import calculator.model.InputValidator;

public class CalculatorService {
    private final Calculator calculator;
    private final DelimiterParser delimiterParser;
    private final InputValidator inputValidator;

    public CalculatorService(Calculator calculator, DelimiterParser delimiterParser, InputValidator inputValidator) {
        this.calculator = calculator;
        this.delimiterParser = delimiterParser;
        this.inputValidator = inputValidator;
    }

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 빈 문자열 또는 공백 문자열 처리
        }

        String delimiter = delimiterParser.parseDelimiter(input); // 커스텀 구분자 파싱
        String[] numbers = delimiterParser.splitNumbers(input, delimiter); // 숫자 배열로 분리

        // 유효성 검사
        inputValidator.validate(numbers); // 숫자 유효성 검사

        // numbers 배열을 사용하여 계산
        return calculator.add(numbers); // 계산 및 결과 반환
    }

}
