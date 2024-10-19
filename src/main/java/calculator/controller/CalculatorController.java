package calculator.controller;

import calculator.model.Adder;
import calculator.model.Formatter;
import calculator.model.delimiter.DelimiterFactory;
import calculator.view.EndView;
import calculator.view.StartView;

public class CalculatorController {

    public static void runCalculator() {
        StartView.printStartView();
        String input = StartView.getInputView();

        String delimiters = DelimiterFactory.getDelimiters(input);
        int[] formatResult = Formatter.formatInput(input, delimiters);
        int result = Adder.addNum(formatResult);

        EndView.printEndView(result);
    }
}
