package calculator.controller;


import calculator.model.Calculator;
import calculator.model.CustomDelimiterProcessor;
import calculator.model.Delimiters;
import calculator.model.NumberExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        Delimiters delimiters = new Delimiters();
        CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor(delimiters);
        inputString = customDelimiterProcessor.addCustomDelimiters(inputString);
        Calculator calculator = new Calculator();
        NumberExtractor.extractNumber(inputString, delimiters, calculator);
        int result = calculator.calculate();
        OutputView.printResultMessage(result);
    }
}