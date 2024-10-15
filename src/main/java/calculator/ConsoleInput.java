package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    public String getUserInput() {
        String userInput = Console.readLine();
        Console.close();
        return userInput;
    }
}
