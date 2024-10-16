package calculator.controller;

import calculator.view.InputView;

public class Controller {

    public void run() {
        System.out.print("숫자를 입력하세요: ");

        String inputNumber = getNumber();
    }

    private String getNumber() {
        InputView inputView = new InputView();
        String input = inputView.inputValue();

        return input;
    }
}
