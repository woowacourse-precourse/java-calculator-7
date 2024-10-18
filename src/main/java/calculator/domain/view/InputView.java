package calculator.domain.view;

import static calculator.domain.message.UserInputMessage.REQUEST_MESSAGE;

public class InputView {

    /**
     * 사용자에게 입력 요청 메시지를 출력합니다.
     */
    public void inputMessage() {
        System.out.println(REQUEST_MESSAGE.getMessage());
    }
}
