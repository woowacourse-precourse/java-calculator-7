package calculator.view;

import static calculator.view.constant.outputMessage.OutputMessage.START_MESSEAGE;

public class OutputView {
    public void print(int value) {
        System.out.println("결과: " + value);
    }


    public void printStart() {
        System.out.println(START_MESSEAGE.getMessage());
    }
}
