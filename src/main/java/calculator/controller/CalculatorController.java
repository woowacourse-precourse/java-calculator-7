package calculator.controller;

import calculator.dto.request.CalculatorRequest;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public void run(){
        InputView inputView = new InputView();
        OutputView.getOutput(calculatorService.calculateInput(new CalculatorRequest(inputView.getInput())).getCalculated());
    }
}
