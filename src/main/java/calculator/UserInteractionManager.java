package calculator;

import static calculator.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class UserInteractionManager {
    public String readInput() {
        System.out.println(PROMPT_MESSAGE);
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        return input;
    }

    public void printOutput(String result) {
        System.out.print(OUTPUT_MESSAGE + result);
    }
}
