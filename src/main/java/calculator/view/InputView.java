package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import calculator.global.constants.MessageType;
import calculator.global.validator.Validator;

public class InputView {
    public static String requestString() {
        OutputView.printMessage(MessageType.STRING_REQUEST_MESSAGE);
        return enterMessage();
    }

    private static String enterMessage() {
        String message = Console.readLine();
        Validator.validateNotEmpty(message); // 입력 검증
        return message;
    }
}