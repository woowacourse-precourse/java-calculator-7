package calculator.controller;

import calculator.domain.Calculator;
import calculator.validator.Validator;
import calculator.view.InputView;

import java.util.ArrayList;

public class CalculatorController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    Calculator calculator = new Calculator();
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
        if (!validator.checkCustomSeparator(input, separator)) {
            throw new IllegalArgumentException("커스텀 구분자를 잘못 입력하였습니다.");
        }
        int sum = calculator.sumNumber(input, separator);
        System.out.println(sum);
    }
}
