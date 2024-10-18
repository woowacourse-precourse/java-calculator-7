package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomSeparator;
import calculator.model.DefaultSeparator;
import calculator.model.Numbers;
import calculator.validator.InputValidator;
import calculator.view.InputReader;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    public void run() {
        OutputView.displayStart();
        String input = InputReader.inputMessage();

        Numbers numbers = new Numbers(getNumbers(input));

        int result = new Calculator().calculateSum(numbers);
        OutputView.displayResult(result);
    } // run

    public List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (containsCustomSeparator(input)) {
            numbers = new CustomSeparator().separate(input);
        } // end if

        if (containsDefaultSeparator(input)) {
            numbers = new DefaultSeparator().separate(input);
        } // end if

        if (notContainsSeparator(input)) {
            numbers = List.of(new InputValidator().validate(input));
        } // end if
        return numbers;
    } // getNumbers

    public boolean containsCustomSeparator(String input) {
        return input.matches("^//(.*)\\\\n(.*)");
    } // containsCustomSeparator

    public boolean containsDefaultSeparator(String input) {
        return !containsCustomSeparator(input) && (input.contains(",") || input.contains(":"));
    } // containsDefaultSeparator

    public boolean notContainsSeparator(String input) {
        return !containsDefaultSeparator(input) && !containsCustomSeparator(input);
    } // notContainsSeparator
} // class