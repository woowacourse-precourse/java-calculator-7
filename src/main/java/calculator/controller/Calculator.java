package calculator.controller;

import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static calculator.common.InputValidator.isBasicSeparator;
import static calculator.common.InputValidator.isCustomSeparator;

import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run () {
        // 입력
        String input = inputView.getInput();

        // 빈 입력 처리 및 숫자 추출
        Numbers numbers = handleInput(input);

        // 덧셈
        Integer sum = numbers.sum();

        // 결과
        outputView.printResult(sum);
    }

    public Numbers handleInput (String input) {
        validateInput(input);

        return new Numbers(input);

    }

    private void validateInput (String input) {
        if (!input.isBlank() && !isCustomSeparator(input) && !isBasicSeparator(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

}
