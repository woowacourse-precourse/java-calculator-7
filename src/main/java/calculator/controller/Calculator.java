package calculator.controller;

import calculator.domain.calculator.CalculatorNumberFactory;
import calculator.domain.calculator.CalculatorNumbers;
import calculator.domain.delimeter.DelimiterFactory;
import calculator.domain.delimeter.Delimiters;
import calculator.dto.ExtractionResult;
import calculator.service.DelimiterExtractor;
import calculator.service.StringSplitter;
import calculator.view.InputView;
import java.util.List;

public class Calculator {
    private final InputView inputView;
    private final DelimiterExtractor delimiterExtractor;

    public Calculator() {
        this.inputView = new InputView();
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public void run() {
        String userInput = inputView.readStringToAdd();

        ExtractionResult extractionResult = delimiterExtractor.extract(userInput);
        Delimiters delimiters = DelimiterFactory.createDelimitersFrom(extractionResult.delimiters());

        StringSplitter stringSplitter = new StringSplitter(delimiters);
        List<String> splitRemainingInput = stringSplitter.split(extractionResult.remainingInput());

        CalculatorNumbers calculatorNumbers = CalculatorNumberFactory.createCalculatorNumbersFrom(splitRemainingInput);

    }
}
