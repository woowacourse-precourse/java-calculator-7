package calculator.controller;

import calculator.domain.DelimiterExtractor;
import calculator.domain.DelimiterFactory;
import calculator.domain.Delimiters;
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

        List<String> extractedDelimiter = delimiterExtractor.extract(userInput);
        Delimiters delimiters = DelimiterFactory.createDelimitersFrom(extractedDelimiter);

        
    }
}
