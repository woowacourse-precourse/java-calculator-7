package calculator.controller;

import calculator.model.NumberParser;
import calculator.model.DelimiterParser;
import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final NumberParser numberParser;
    private final DelimiterParser delimiterParser;
    private final ErrorResponseHandler errorResponseHandler; // ErrorResponseHandler 추가

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        this.numberParser = new NumberParser();
        this.delimiterParser = new DelimiterParser();
        this.errorResponseHandler = new ErrorResponseHandler(); // 인스턴스 생성
    }

    public String handleRequest(String input) {
        try {
            // DelimiterParser를 사용하여 입력값 파싱
            String[] numbers = delimiterParser.parse(input);

            // 파싱된 숫자들을 검증
            for (String number : numbers) {
                if (!number.trim().isEmpty()) {
                    int parsedNumber = numberParser.parseNumber(number.trim());
                    numberParser.validatePositive(parsedNumber); // 이 메서드에서 예외 발생 가능
                }
            }

            // 계산 서비스 호출
            return String.valueOf(calculatorService.calculate(String.join(",", numbers)));
        } catch (IllegalArgumentException e) {
            return errorResponseHandler.handleError(e); // 에러 메시지 반환
        }
    }


}
