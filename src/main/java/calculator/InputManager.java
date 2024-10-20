package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String inputStr() {
        System.out.println(Constants.INPUT_MESSAGE);
        return Console.readLine();
    }
}
