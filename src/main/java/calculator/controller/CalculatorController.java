package calculator.controller;

import calculator.model.CustomStringParser;
import calculator.model.NumberStringSplitter;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CustomStringParser customStringParser;
    private final NumberStringSplitter numberStringSplitter;
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CustomStringParser customStringParser,
                                NumberStringSplitter numberStringSplitter,
                                CalculatorOutputView calculatorOutputView) {
        this.customStringParser = customStringParser;
        this.numberStringSplitter = numberStringSplitter;
        this.calculatorOutputView = calculatorOutputView;
    }

    public void processInput(String inputStr) {
        if (inputStr.isEmpty()) {
            calculatorOutputView.printResult("0");
            return;
        }

        inputStr = customStringParser.parse(inputStr);
        String[] inputStrArr = numberStringSplitter.split(inputStr);
    }
}
