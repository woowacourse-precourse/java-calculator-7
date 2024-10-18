package calculator.domain.view;

import static calculator.domain.message.UserOutputMessage.RESPONSE_MESSAGE;

public class OutputView {

    /**
     * 계산 결과를 출력합니다.
     *
     * @param result 계산된 결과 값
     */
    public void outputMessage(int result) {
        System.out.print(RESPONSE_MESSAGE.getMessage() + result);
    }
}
