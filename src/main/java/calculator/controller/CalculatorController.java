package calculator.controller;

import calculator.model.CustomStringParser;
import calculator.model.NumberStringConverter;
import calculator.model.NumberStringSplitter;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CustomStringParser customStringParser;
    private final NumberStringSplitter numberStringSplitter;
    private final NumberStringConverter numberStringConverter;
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CustomStringParser customStringParser,
                                NumberStringSplitter numberStringSplitter,
                                NumberStringConverter numberStringConverter,
                                CalculatorOutputView calculatorOutputView) {
        this.customStringParser = customStringParser;
        this.numberStringSplitter = numberStringSplitter;
        this.numberStringConverter = numberStringConverter;
        this.calculatorOutputView = calculatorOutputView;
    }

    public void processInput(String inputStr) {
        if (inputStr.isEmpty()) {
            calculatorOutputView.printResult("0");
            return;
        }

        inputStr = customStringParser.parse(inputStr);
        String[] inputStrArr = numberStringSplitter.split(inputStr);
        long[] numbers = numberStringConverter.convert(inputStrArr);
    }
}
