package calculator;

import java.util.List;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private final Delimiters delimiters;
    private final StringChecker stringChecker;
    private final CustomDelimiterChecker customDelimiterChecker;
    private final StringSplitter stringSplitter;
    private final SumCalculator sumCalculator;
    private String inputString;

    public CalculatorController(String inputString) {
        this.inputString = inputString;
        this.delimiters = new Delimiters();
        this.stringChecker = new StringChecker(inputString, delimiters);
        this.customDelimiterChecker = new CustomDelimiterChecker(inputString);
        this.stringSplitter = new StringSplitter(inputString, delimiters);
        this.sumCalculator = new SumCalculator();
        startCalculator();
    }

    private void startCalculator() {
        if (stringChecker.checkEmpty()) {
            calculatorView.printResult(0);
            return;
        }

        stringChecker.checkBoundary();

        if (customDelimiterChecker.hasCustomDelimiter()) {
            String customDelimiter = customDelimiterChecker.checkCustomDelimiter();
            delimiters.addDelimiter(customDelimiter);
            inputString = customDelimiterChecker.getInputString();
            stringSplitter.setSplitter(inputString, delimiters);
        }

        List<Integer> numbers = stringSplitter.splitString();
        sumCalculator.setNumbers(numbers);
        calculatorView.printResult(sumCalculator.sumNumbers());
    }
}
