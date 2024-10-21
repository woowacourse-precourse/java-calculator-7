package calculator.view;

import calculator.model.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public static String readInput(){
        String input = Console.readLine();
        InputValidator.validateNotNull(input);
        if (input.isEmpty()) {
            input = "0";
            return input;
        }

        return input;
    }

}
