package calculator.controller;

import calculator.domain.Calculator;
import calculator.validator.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class CalculatorController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    Calculator calculator = new Calculator();



    public void run() {
        String input = inputView.readSentence();
        ArrayList<String> separators = calculator.getSeparators();

        if (!validator.checkIsEmpty(input) && !validator.checkHasNumber(input)) {
            System.out.println("0");
            return;
        }
        if (!validator.checkCustomSeparator(input, separators)) {
            throw new IllegalArgumentException("커스텀 구분자를 잘못 입력하였습니다.");
        }
        if (validator.checkHasNegative(input, separators)) {
            throw new IllegalArgumentException("음수를 입력하였습니다.");
        }
        if (!validator.checkIsCorrectString(input, separators)) {
            throw new IllegalArgumentException("올바른 문자열이 아닙니다.");
        }
        int sum = calculator.sumNumber(input, separators);
        outputView.printResult(sum);
    }
}
