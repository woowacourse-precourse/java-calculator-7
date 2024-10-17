package calculator.service;

import calculator.enums.ErrorMessages;
import calculator.view.InputView;

import static calculator.util.Validator.validateCustomDelimiter;

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
}
