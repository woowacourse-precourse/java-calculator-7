package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        while (true) {

            // TODO:
            //  시작 시 InputView 객체 생성해서 사용자 입력 받고
            //  validate하고
            //  add하고
            //  return한다.(OutputView)

            inputView.getUserInput();               // 사용자 입력 받기
        }
    }
}
