package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String enterNumbers() {
        System.out.println(ViewMessages.NUMBERS_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
