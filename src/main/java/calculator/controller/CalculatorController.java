package calculator.controller;

import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.service.CalculatorService;
import calculator.util.Container;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = Container.getInstance(CalculatorService.class);
    }

    public CalculatorResponse calculate(CalculatorRequest request) {
        return CalculatorResponse.from(calculatorService.calculate(request));
    }
}