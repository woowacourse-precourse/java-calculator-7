package calculator.handler;

import static calculator.model.InputString.CUSTOM_DELIMITER_RANGE;

import calculator.view.InputView;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String getValidatedInput() {
        String input = inputView.getInputString();

        validate(input);

        if (input.startsWith("//") && input.substring(CUSTOM_DELIMITER_RANGE).isEmpty()) {
            input = inputView.getInputStringFromNextLine(input);
        }

        return input;
    }

    /**
     * 입력받은 문자열에 대해 유효성 검증
     */
    private void validate(String input) {
        if (input.startsWith("//") && input.contains("\\n") && !input.startsWith("\\n", CUSTOM_DELIMITER_RANGE)) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 입력 형식이 아닙니다.");
        }
        if (input.startsWith("//") && !input.contains("\\n") && input.length() > 3) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 입력 형식이 아닙니다.");
        }
    }
}
