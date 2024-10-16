package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public void run() {
        System.out.print("숫자를 입력하세요: ");

        String inputNumber = getNumber();

        // 계산 메서드

        // 결과값 출력
        String result = getResult(100);
        System.out.println(result);
    }

    private String getNumber() {
        InputView inputView = new InputView();
        String input = inputView.inputValue();

        return input;
    }

    private String getResult(int answer) {
        OutputView outputView = new OutputView();
        return outputView.getResult(answer);
    }
}
