package calculator.stringCalculator;

import calculator.stringCalculator.calculator.Calculator;
import calculator.stringCalculator.calculatorInterface.CalculatorInterface;
import calculator.stringCalculator.parser.Parser;

import java.util.List;


public class StringCalculator {

    private final Parser parser;
    private final CalculatorInterface calculatorInterface;
    private final Calculator calculator;

    public StringCalculator() {
        parser = new Parser();
        calculatorInterface = new CalculatorInterface();
        calculator = new Calculator();
    }

    public void start() {
        String userInput = calculatorInterface.getUserInput();
        List<Long> numberList = parser.parse(userInput);
        long result = calculator.sum(numberList);
        calculatorInterface.printResult(result);
    }
}
