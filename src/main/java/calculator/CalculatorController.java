package calculator;

import java.util.List;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private final Delimiters delimiters;
    private final StringChecker stringChecker;
    private final StringSplitter stringSplitter;
    private String inputString;

    public CalculatorController(String inputString) {
        this.inputString = inputString;
        this.delimiters = new Delimiters();
        this.stringChecker = new StringChecker(inputString, delimiters);
        this.stringSplitter = new StringSplitter(inputString, delimiters);
        startCalculator();
    }

    private void startCalculator() {
        if (stringChecker.checkEmpty()) {
            calculatorView.printResult(0);
            return;
        }

        stringChecker.checkBoundary();
        inputString = stringChecker.checkCustomDelimiter();
        List<Integer> numbers = stringSplitter.splitString();
        calculate(numbers);
    }

    private void calculate(List<Integer> numbers) {
        int sumResult = 0;
        for (int i : numbers) {
            sumResult += i;
        }

        calculatorView.printResult(sumResult);
    }
}
