package calculator.controller;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getUserInput() {
        String userInput = Console.readLine();
        Console.close();
        return userInput;
    }
}