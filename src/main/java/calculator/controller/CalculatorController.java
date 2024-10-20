package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * controller
 */
public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자로부터 문자열을 입력받는다.
     */
    public void run() {
        String input = inputView.getInputString();  // 덧셈할 문자열을 입력해주세요.

        validateInputString(input);

        input = inputView.getInputStringFromNextLine(input);

        InputString inputString = new InputString(input);

        long resultSum = inputString.calculate();  // 문자열 계산

        outputView.getOutputResult(resultSum);
    }

    /**
     * 입력받은 문자열에 대해 유효성 검증
     */
    private void validateInputString(String input) {
        if (input.startsWith("//") && !input.substring(3, 5).equals("\\n")) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 입력 형식이 아닙니다.");
        }
    }

}
