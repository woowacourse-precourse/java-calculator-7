package calculator.controller;

import calculator.dto.AddCalculatorRequest;
import calculator.dto.AddCalculatorResponse;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public AddCalculatorResponse addCalculator(AddCalculatorRequest request){
        return new AddCalculatorResponse(calculatorService.addCalculator(request.userInput()));
    }
}
