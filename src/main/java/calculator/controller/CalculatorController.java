package calculator.controller;

import calculator.machine.CalculatingMachine;
import calculator.separator.CustomSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final String customPrefix = "//";
    private Separator separator;
    private final CalculatingMachine calculatingMachine;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatingMachine = new CalculatingMachine();
        this.calculatorView = new CalculatorView();
    }

    //todo: 리팩토링 필요
    public void startCalculate() {
        String userInput = calculatorView.getUserInput();
        if (userInput.startsWith(customPrefix)) {
            this.separator = new CustomSeparator();
            Long result = calculatingMachine.calculate(separator.separate(userInput));
            calculatorView.getResult(result);
            return;
        }
        this.separator = new DefaultSeparator();
        Long result = calculatingMachine.calculate(separator.separate(userInput));
        calculatorView.getResult(result);
    }
}
