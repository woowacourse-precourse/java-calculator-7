package calculator.view;

import static calculator.global.Message.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String receiveInput() {
        System.out.println(INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

}

