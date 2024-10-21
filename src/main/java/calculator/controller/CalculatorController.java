package calculator.controller;

import calculator.model.CustomDelimiterParser;
import calculator.model.NumberStringConverter;
import calculator.model.NumberStringSplitter;
import calculator.model.SumCalculator;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CustomDelimiterParser customDelimiterParser;
    private final NumberStringSplitter numberStringSplitter;
    private final SumCalculator sumCalculator;
    private final NumberStringConverter numberStringConverter;
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CustomDelimiterParser customDelimiterParser, NumberStringSplitter numberStringSplitter,
                                NumberStringConverter numberStringConverter, SumCalculator sumCalculator,
                                CalculatorOutputView calculatorOutputView) {
        this.customDelimiterParser = customDelimiterParser;
        this.numberStringSplitter = numberStringSplitter;
        this.numberStringConverter = numberStringConverter;
        this.sumCalculator = sumCalculator;
        this.calculatorOutputView = calculatorOutputView;
    }

    public void processInput(String inputStr) {
        if (inputStr.isEmpty()) {
            calculatorOutputView.printResult("0");
            return;
        }

        inputStr = customDelimiterParser.parse(inputStr);
        String[] inputStrArr = numberStringSplitter.split(inputStr);
        long[] numbers = numberStringConverter.convert(inputStrArr);

        String result = sumCalculator.calculate(numbers);
        calculatorOutputView.printResult(result);
    }
}
