package calculator.controller;

import static calculator.model.InputString.CUSTOM_DELIMITER_RANGE;

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
     * 문자열 계산기 실행
     */
    public void run() {
        String input = inputView.getInputString();

        validateInputString(input);

        if (input.startsWith("//") && input.substring(CUSTOM_DELIMITER_RANGE).isEmpty()) {
            input = inputView.getInputStringFromNextLine(input);
        }

        InputString inputString = new InputString(input);

        long resultSum = inputString.calculate();  // 문자열 계산

        outputView.getOutputResult(resultSum);
    }

    /**
     * 입력받은 문자열에 대해 유효성 검증
     */
    private void validateInputString(String input) {
        if (input.startsWith("//") && input.contains("\\n") && !input.startsWith("\\n", CUSTOM_DELIMITER_RANGE)) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 입력 형식이 아닙니다.");
        }
        if (input.startsWith("//") && !input.contains("\\n") && input.length() > 3) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 입력 형식이 아닙니다.");
        }
    }

}
