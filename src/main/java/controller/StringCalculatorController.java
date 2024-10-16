package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.StringCalculator;
import view.ConsoleView;

public class StringCalculatorController {
    private final StringCalculator calculator;
    private final ConsoleView consoleView;

    public StringCalculatorController() {
        this.calculator = new StringCalculator();
        this.consoleView = new ConsoleView();
    }

    public void run(){
        String input = consoleView.getInput();

        int result = calculator.add(input);

        consoleView.displayResult(result);
    }
}
