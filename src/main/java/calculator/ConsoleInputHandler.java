package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler {

    public static String getUserInput() throws IllegalArgumentException{

        String userInput = Console.readLine();

        if(InputValidator.validate(userInput)){

            return userInput;

        }

        throw new IllegalArgumentException();
    }


}
