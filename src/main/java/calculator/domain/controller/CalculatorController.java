package calculator.domain.controller;

import calculator.domain.DelimiterParser;
import calculator.domain.InputParser;
import calculator.domain.StringSplitter;
import calculator.domain.SumCalculator;
import calculator.view.OutputView;


public class CalculatorController {

    private final InputParser inputParser;
    private final DelimiterParser delimiterParser;
    private final StringSplitter stringSplitter;
    private final SumCalculator sumCalculator;

    public CalculatorController(InputParser inputParser, DelimiterParser delimiterParser,
                                StringSplitter stringSplitter, SumCalculator sumCalculator) {
        this.inputParser = inputParser;
        this.delimiterParser = delimiterParser;
        this.stringSplitter = stringSplitter;
        this.sumCalculator = sumCalculator;
    }

    public int processInput(String input) {

        inputParser.parse(input);
        String delimiterString = inputParser.getDelimiterString();
        String inputString = inputParser.getInputString();

        delimiterParser.parse(delimiterString);
        String delimiter = delimiterParser.getDelimiter();

        String[] numbers = stringSplitter.split(inputString, delimiter);

        return sumCalculator.calculateSum(numbers);
    }

    public void run(String input) {
        int totalSum = processInput(input);
        OutputView.totalOutputLine(String.valueOf(totalSum));
    }
}
