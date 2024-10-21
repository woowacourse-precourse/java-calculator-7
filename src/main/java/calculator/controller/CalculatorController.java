package calculator.controller;

import calculator.domain.DelimiterExtractor;
import calculator.view.View;

public class CalculatorController {
    private final DelimiterExtractor delimiterExtractor;


    public CalculatorController() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public void run() {
        String input = View.requestString();

        String delimiters = delimiterExtractor.extract(input);
    }
}
