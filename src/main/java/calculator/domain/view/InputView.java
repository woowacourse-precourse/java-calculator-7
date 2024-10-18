package calculator.domain.view;

import static calculator.domain.message.UserInputMessage.REQUEST_MESSAGE;

public class InputView {

    public void inputMessage() {
        System.out.println(REQUEST_MESSAGE.getMessage());
    }
}
