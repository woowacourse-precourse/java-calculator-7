package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static String firstInput;
    private static String secondInput;

    public void readFirstInput() {
        firstInput = Console.readLine();
    }

    public boolean isDefaultInput() {
        return !firstInput.startsWith("//");
    }

    public String getFirstInput() {
        return firstInput;
    }
}
