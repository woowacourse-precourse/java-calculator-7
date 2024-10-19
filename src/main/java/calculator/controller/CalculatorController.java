package calculator.controller;

import calculator.validator.Validator;
import calculator.view.InputView;

import java.util.ArrayList;

public class CalculatorController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    ArrayList<String> separator = new ArrayList<>();

    public CalculatorController() {
        separator.add(",");
        separator.add(":");
    }

    public void run() {
        String input = inputView.readSentence();
        boolean isEmpty = validator.checkIsEmpty(input);
        if (!validator.checkHasNumber(input)) {
            System.out.println("0");
            return;
        }
        validator.checkCustomSeparator(input, separator);

    }
}
