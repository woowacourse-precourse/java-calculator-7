package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final ErrorResponseHandler errorResponseHandler;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        this.errorResponseHandler = new ErrorResponseHandler();
    }

    public String handleRequest(String input) {
        try {
            int result = calculatorService.calculate(input);
            return String.valueOf(result); // 결과를 문자열로 변환하여 반환
        } catch (IllegalArgumentException e) {
            return errorResponseHandler.handleError(e);
        }
    }
}
