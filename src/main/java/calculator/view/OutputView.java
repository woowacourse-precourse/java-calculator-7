package calculator.view;

import static calculator.constant.MessageConstant.CALCULATOR_START_MESSAGE;
import static calculator.constant.MessageConstant.RESULT_MESSAGE;

public class OutputView {
    public void printStartMessage() {
        System.out.println(CALCULATOR_START_MESSAGE.getMessage());
    }
    
    public void printResultMessage(Integer result) {
        System.out.println(RESULT_MESSAGE.getMessage() + result);
    }
}
