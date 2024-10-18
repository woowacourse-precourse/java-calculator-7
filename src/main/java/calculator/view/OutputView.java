package calculator.view;

import static calculator.message.UserOutputMessage.RESPONSE_MESSAGE;

public class OutputView {

    public void outputMessage(int result) {
        System.out.print(RESPONSE_MESSAGE.getMessage() + result);
    }
}
