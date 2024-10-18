package calculator.view;

import calculator.view.enums.Message;

public class OutputView {

    public void displayInputPrompt() {
        System.out.println(Message.REQUEST_INPUT.getMessage());
    }

}
