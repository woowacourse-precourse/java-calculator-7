package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public UserInput getUserAction() {
        String input = Console.readLine();
        return new UserInput(input);
    }

}
