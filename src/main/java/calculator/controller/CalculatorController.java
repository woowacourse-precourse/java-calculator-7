package calculator.controller;

import calculator.view.ConsoleView;
import calculator.model.StringAdd;

public class CalculatorController {

    private final StringAdd stringAdd;
    private final ConsoleView consoleView;

    public CalculatorController() {
        this.stringAdd = new StringAdd();
        this.consoleView = new ConsoleView();
    }

    public void run() {
        String input = consoleView.getInput();
        int result = stringAdd.add(input);
        consoleView.outputResult(result);
    }

}
