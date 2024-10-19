package calculator.controller;

import calculator.model.CalculateModel;
import calculator.view.ConsoleView;

public class CalculateController {

    private final ConsoleView consoleView;
    private final CalculateModel calculateModel;

    public CalculateController(ConsoleView consoleView, CalculateModel calculateModel) {
        this.consoleView = consoleView;
        this.calculateModel = calculateModel;
    }

    public void run() {
        String input = consoleView.input();
        int result = calculateModel.add(input);
        consoleView.displayResult(result);
    }
}
