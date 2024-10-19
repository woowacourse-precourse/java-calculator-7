package calculator.controller;

import calculator.model.delimiter.DelimiterFactory;
import calculator.view.StartView;

public class CalculatorController {

    public static void runCalculator() {
        StartView.printStartView();
        String input = StartView.getInputView();

        String delimiters = DelimiterFactory.getDelimiters(input);
    }
}
