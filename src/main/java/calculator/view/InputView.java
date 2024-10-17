package calculator.view;

import calculator.global.constant.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputStringToAdd() {
        System.out.println(InputMessage.INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
