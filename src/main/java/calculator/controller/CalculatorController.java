package calculator.controller;

import calculator.model.CustomStringParser;
import calculator.model.NumberStringConverter;
import calculator.model.NumberStringSplitter;
import calculator.model.SumCalculator;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CustomStringParser customStringParser;
    private final NumberStringSplitter numberStringSplitter;
    private final SumCalculator sumCalculator;
    private final NumberStringConverter numberStringConverter; // 추가된 부분
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CustomStringParser customStringParser,
                                NumberStringSplitter numberStringSplitter,
                                NumberStringConverter numberStringConverter,
                                SumCalculator sumCalculator,
                                CalculatorOutputView calculatorOutputView) {
        this.customStringParser = customStringParser;
        this.numberStringSplitter = numberStringSplitter;
        this.numberStringConverter = numberStringConverter; // 추가된 부분
        this.sumCalculator = sumCalculator;
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

        String result = sumCalculator.calculate(numbers);
        calculatorOutputView.printResult(result);
    }
}
