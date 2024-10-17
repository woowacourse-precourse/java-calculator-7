package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PROMPT_MESSAGE_REQUEST_INPUT = "덧셈할 문자열을 입력해 주세요.";
    private static final String ERROR_MESSAGE_USER_INPUT = "잘못된 값을 입력하였습니다.(공백 불가)";

    public String receiveUserInput() {
        System.out.println(PROMPT_MESSAGE_REQUEST_INPUT);
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return userInput;
    }

    protected void validateUserInput(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_USER_INPUT);
        }
    }
}
