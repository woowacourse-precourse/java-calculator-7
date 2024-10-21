package calculator.controller;

import calculator.service.StringCalculator;
import calculator.view.ConsoleView;

public class StringCalculatorController {
    private final ConsoleView view;

    public StringCalculatorController(ConsoleView view) {
        this.view = view;
    }

    public void run() {
        String input = view.getInput();

        int result = StringCalculator.add(input);
        view.printResult(result);
    }
}
