package calculator.view;

import static calculator.constant.MessageConstant.RESULT_MESSAGE;

public class OutputView {

    public void printResultMessage(Integer result) {
        System.out.println(RESULT_MESSAGE.getMessage() + result);
    }
}
