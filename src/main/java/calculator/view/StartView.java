package calculator.view;


import static calculator.enumStatus.UserMessage.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public static void printStartView() {
        System.out.println(START_MESSAGE);
    }

    public static String getInputView() {
        return Console.readLine();
    }
}
