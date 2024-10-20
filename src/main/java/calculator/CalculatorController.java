package calculator;

import calculator.dto.NumberRequest;

public class CalculatorController {
    CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void run() {
        NumberRequest numberRequest = calculatorView.welcomeMessage();

    }
}
