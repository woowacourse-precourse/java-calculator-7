package calculator.view;

import static calculator.view.ViewMessage.RESULT_MESSAGE;

public class OutputView {
    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE.getResultMessage(result));
    }
}
