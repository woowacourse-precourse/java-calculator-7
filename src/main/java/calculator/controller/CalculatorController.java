package calculator.controller;

import calculator.model.Adder;
import calculator.model.Formatter;
import calculator.model.delimiter.DelimiterFactory;
import calculator.view.EndView;
import calculator.view.StartView;

public class CalculatorController {

    public static void runCalculator() {
        String input = startCalculator();

        int result = proceedCalculator(input);

        EndView.printEndView(result);
    }

    private static String startCalculator() {
        StartView.printStartView();
        return StartView.getInputView();
    }

    private static int proceedCalculator(String input) {
        String delimiters = DelimiterFactory.getDelimiters(input);
        int[] formatResult = Formatter.formatInput(input, delimiters);
        return Adder.addNum(formatResult);
    }
}
