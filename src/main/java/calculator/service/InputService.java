package calculator.service;

import calculator.enums.ErrorMessages;
import calculator.view.InputView;

public class InputService {

    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public String getValidInput() {
        //TODO: 사용자 입력 받기 및 검증 로직 구현
        try {
            String input = inputView.readInput();
            validateCustomDelimiter(input);
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateCustomDelimiter(String input) {
        //TODO: 커스텀 구분자 검증 로직 구현
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException(ErrorMessages.MISSING_NEWLINE.getMessage());
            }

            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.MISSING_CUSTOM_DELIMITER.getMessage());
            }
        }
    }
}
