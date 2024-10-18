package calculator.controller;

import calculator.model.CustomSeparator;
import calculator.model.DefaultSeparator;
import calculator.view.InputReader;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    public void run() {
        OutputView.displayStart();
        String input = InputReader.inputMessage();

        if (containsCustomSeparator(input)) {
            new CustomSeparator().separate(input);
        } // end if

        if (containsDefaultSeparator(input)) {
            List<Integer> test = new DefaultSeparator().separate(input);
            System.out.println(test);
        } // end if
    } // run

    public boolean containsCustomSeparator(String input) {
        return input.matches("^//(.*)\\\\n(.*)");
    } // containsCustomSeparator

    public boolean containsDefaultSeparator(String input) {
        return input.contains(",") || input.contains(":");
    } // containsDefaultSeparator

    public static void main(String[] args) {
        new CalculatorController().run();
    }
} // class