package calculator.controller;

import calculator.dto.request.CalculateRequest;
import calculator.dto.response.CalculateResultResponse;
import calculator.service.CalculatorService;
import calculator.util.SingletonObjectProvider;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = SingletonObjectProvider.getSingletonObject(CalculatorService.class);
    }

    public CalculateResultResponse calculate(CalculateRequest request) {
        int result = calculatorService.calculate(request.input());
        return CalculateResultResponse.from(result);
    }
}
