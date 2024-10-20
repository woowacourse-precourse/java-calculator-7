package calculator.controller;

import calculator.model.CustomStringParser;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CustomStringParser customStringParser;
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CustomStringParser customStringParser, CalculatorOutputView calculatorOutputView) {
        this.customStringParser = customStringParser;
        this.calculatorOutputView = calculatorOutputView;
    }

    public void processInput(String inputStr) {
        if (inputStr.isEmpty()) {
            calculatorOutputView.printResult("0");
        }

        inputStr = customStringParser.parse(inputStr);
    }
}
