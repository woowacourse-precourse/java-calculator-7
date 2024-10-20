package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Validator;
import calculator.view.InputReader;
import calculator.view.OutputWriter;

public class CalculatorController {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final Validator validator;
    private final Calculator calculator;

    public CalculatorController(InputReader inputReader, OutputWriter outputWriter, Validator validator, Calculator calculator) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.validator = validator;
        this.calculator = calculator;
    }

    public void run() {
        String input = inputReader.readLine();
        String[] numbers = calculator.extractNumbers(input);
        int[] numbersArray = validator.validateAndConvert(numbers);
        int result = calculator.sum(numbersArray);
        outputWriter.print(result);
    }

}