package calculator.front.view;

import calculator.front.enums.ViewMessage;

public class OutputView {
    public void write(String output) {
        System.out.println(ViewMessage.OUTPUT_MESSAGE.getMessage() + output);
    }
}

