package calculator.controller;

import calculator.service.Calculator;
import calculator.service.CalculatorImpl;
import calculator.utils.InputValidator;
import calculator.view.OutputView;
import java.math.BigDecimal;

public class CalculatorController {

    private final String input;
    private final Calculator calculator;

    public CalculatorController(String input) {
        this.input = input;
        this.calculator = new CalculatorImpl();
    }

    public void run(){
        InputValidator.validateInput(input);
        calculator.initValues(input);
        BigDecimal result = calculator.execute();
        OutputView.getOutputMessage(result);
    }

}
