package calculator.view;

import static calculator.view.constant.outputMessage.OutputMessage.RESULT_MESSAGE;
import static calculator.view.constant.outputMessage.OutputMessage.START_MESSEAGE;

public class OutputView {
    public void print(int value) {
        System.out.println(RESULT_MESSAGE.getMessage() + value);
    }


    public void printStart() {
        System.out.println(START_MESSEAGE.getMessage());
    }
}
