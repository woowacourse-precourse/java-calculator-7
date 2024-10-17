package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static String inputStringWithoutSpaces() {
        String input = Console.readLine().replace(SPACE, EMPTY_STRING);
        return input;
    }
}
