package calculator.controller;

import calculator.machine.CalculatingMachine;
import calculator.separator.CustomSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
import calculator.view.CalculatorView;

public class CalculatorController {
    private Separator separator;
    private final CalculatingMachine calculatingMachine;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatingMachine = new CalculatingMachine();
        this.calculatorView = new CalculatorView();
    }

    public void startCalculate() {
        String userInput = calculatorView.getUserInput();
        setSeparator(userInput);
        Long result = calculatingMachine.calculate(separator.separate(userInput));
        calculatorView.getResult(result);
    }

    public void setSeparator(String userInput) {
        if (userInput.startsWith("//")) {
            this.separator = new CustomSeparator();
            return;
        }
        this.separator = new DefaultSeparator();
    }
}
