package calculator.view;

import calculator.enums.UserInterfaceMsg;

public class OutputView {
    public void printResult(Integer output) {
        System.out.println(String.format(UserInterfaceMsg.CALC_RESULT.getValue(), output));


    }
}
