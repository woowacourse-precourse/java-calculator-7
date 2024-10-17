package calculator.controller;

import calculator.dto.request.CalculateRequest;
import calculator.service.CalculatorService;
import calculator.util.SingletonObjectProvider;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = SingletonObjectProvider.getSingletonObject(CalculatorService.class);
    }

    public void calculate(CalculateRequest request) {
        // TODO 구현해주세요.
    }
}
