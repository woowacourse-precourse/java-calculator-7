package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    static String inputData;

    public static void input() {
        inputData = Console.readLine();
    }

    public static String getInputData() {
        return inputData;
    }
}
