package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;

/**
 * controller
 */
public class CalculatorController {

    private final InputView inputView = new InputView();

    /**
     * 애플리케이션 시작
     */
    public void run() {
        createInputString();
    }

    /**
     * 사용자로부터 문자열을 입력받는다.
     */
    private void createInputString() {
        String input = inputView.getInputString();  // 덧셈할 문자열을 입력해주세요.
        InputString inputString = new InputString(input);

        long resultSum = inputString.calculate();  // 문자열 계산
    }

}
