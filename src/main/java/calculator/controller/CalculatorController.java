package calculator.controller;

import calculator.calculator.NumberCalculator;
import calculator.parser.ParseResult;
import calculator.parser.StringParser;
import calculator.ui.UserInterface;

public class CalculatorController {
    private final UserInterface ui;

    public CalculatorController(UserInterface ui) {
        this.ui = ui;
    }

    public void run(){
        ui.displayPrompt();
        String input = ui.getInput();
        ParseResult result = StringParser.parse(input);
        int sum = NumberCalculator.calc(result.getNumbers());
        ui.displayResult(sum);
    }
}
