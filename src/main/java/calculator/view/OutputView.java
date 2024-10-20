package calculator.view;

import calculator.message.RunMessage;

public class OutputView {
    public void printStart() {
        System.out.print(RunMessage.START.getMessage());
    }
    
    public void printResult(int result) {
        System.out.printf(RunMessage.RESULT.getMessage(), result);
    }
}
