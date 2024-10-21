package calculator.stringCalculator;

import calculator.stringCalculator.calculator.Calculator;
import calculator.stringCalculator.calculatorInterface.CalculatorInterface;
import calculator.stringCalculator.parser.Parser;

import java.util.List;


public class StringCalculator {

    private Parser parser;
    private CalculatorInterface calculatorInterface;
    private Calculator calculator;

    private String userInput;

    public StringCalculator() {
        parser = new Parser();
        calculatorInterface = new CalculatorInterface();
        calculator = new Calculator();
    }

    public void start() {
        userInput = calculatorInterface.getUserInput();
        List<Long> numberList = parser.parse(userInput);
        long result = calculator.sum(numberList);
        calculatorInterface.printResult(result);
    }
}
