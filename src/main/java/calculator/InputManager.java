package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String inputStr() {
        System.out.println(Constant.INPUT_MESSAGE);
        return Console.readLine();
    }
}
