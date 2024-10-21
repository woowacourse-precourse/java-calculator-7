package calculator.view;

import calculator.util.Constants;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getStringInput() {
        System.out.println(Constants.INPUT_MESSAGE);
        return Console.readLine();
    }
}
