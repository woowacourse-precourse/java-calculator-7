package calculator.controller;

import calculator.model.CustomSeparator;
import calculator.view.InputReader;
import calculator.view.OutputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    public void run() {
        OutputView.displayStart();
        String input = InputReader.inputMessage();

        if (containsCustomSeparator(input)) {
            new CustomSeparator().separate(input);
        } // end if
    } // run

    public boolean containsCustomSeparator(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    } // containsCustomSeparator
} // class