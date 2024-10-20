package calculator.controller;

import calculator.domain.DelimiterFactory;
import calculator.domain.Delimiters;
import calculator.dto.ExtractionResult;
import calculator.service.DelimiterExtractor;
import calculator.view.InputView;

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


    }
}
