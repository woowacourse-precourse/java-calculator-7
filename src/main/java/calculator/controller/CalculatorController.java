package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {

    InputView inputView = new InputView();

    public void run() {
        String userInput = inputView.input("덧셈할 문자열을 입력해 주세요.");
    }
}
