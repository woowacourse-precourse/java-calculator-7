package calculator.view;

import calculator.global.OutputMessage;

public class OutputView {
    public void print(OutputMessage message){
        System.out.print(message.getMessage());
    }

    public void println(OutputMessage message){
        System.out.println(message.getMessage());
    }
}
