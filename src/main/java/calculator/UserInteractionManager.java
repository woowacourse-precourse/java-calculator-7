package calculator;

import static calculator.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class UserInteractionManager {
    public String readInput() {
        System.out.println(PROMPT_MESSAGE);
        return Console.readLine();
    }

    public void printOutput(String result) {
        System.out.print(OUTPUT_MESSAGE + result);
    }
}
