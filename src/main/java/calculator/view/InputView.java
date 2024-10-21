package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.enums.UserInterfaceMsg;

public class InputView {
    public String requestInputCalcString() {
        printMessage(UserInterfaceMsg.CALCULATOR_INTRO.getValue());
        return readLine();

    }
    public void printMessage(String message) {
        System.out.println(message);
    }
}
