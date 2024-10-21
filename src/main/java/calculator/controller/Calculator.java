package calculator.controller;

import calculator.domain.calculator.CalculatorNumberFactory;
import calculator.domain.calculator.CalculatorNumbers;
import calculator.domain.delimeter.DelimiterFactory;
import calculator.domain.delimeter.Delimiters;
import calculator.dto.ExtractionResult;
import calculator.service.DelimiterExtractor;
import calculator.service.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterExtractor delimiterExtractor;
    private final StringSplitter stringSplitter;

    public Calculator() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.delimiterExtractor = new DelimiterExtractor();
        this.stringSplitter = new StringSplitter();
    }

    public void run() {
        String userInput = inputView.readStringToAdd();
        long result = calculateSum(userInput);

        outputView.printResult(result);
    }

    private long calculateSum(String input) {
        List<String> numbers = extractNumbers(input);
        CalculatorNumbers calculatorNumbers = CalculatorNumberFactory.createCalculatorNumbersFrom(numbers);

        return calculatorNumbers.sum();
    }

    private List<String> extractNumbers(String input) {
        ExtractionResult extractionResult = delimiterExtractor.extract(input);
        Delimiters delimiters = DelimiterFactory.createDelimitersFrom(extractionResult.delimiters());

        return stringSplitter.split(extractionResult.remainingInput(), delimiters);
    }
}