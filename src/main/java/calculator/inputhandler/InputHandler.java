package calculator.inputhandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public static String getInput(String prompt) {
        System.out.print(prompt);

        return readLine();
    }
}
