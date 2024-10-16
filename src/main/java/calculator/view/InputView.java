package calculator.view;

import static calculator.common.exception.ErrorMessage.BLANK_INPUT_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String OPERATION_STRING_REQUEST_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public String inputOperationString() {
        System.out.println(OPERATION_STRING_REQUEST_PROMPT);
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String message) {
            validateBlank(message);
            return message;
        }

        private static void validateBlank(String message) {
            if (message.isBlank()) {
                throw new IllegalArgumentException(BLANK_INPUT_ERROR);
            }
        }
    }
}
