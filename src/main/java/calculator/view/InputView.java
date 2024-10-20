package calculator.view;

import static calculator.constant.MessageConstant.CALCULATOR_START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getString() {
        System.out.println(CALCULATOR_START_MESSAGE.getMessage());
        return Console.readLine();
    }
}
