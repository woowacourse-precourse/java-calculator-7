package calculator.inputhandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public String getInput(String prompt) {
        System.out.print(prompt);

        return readLine();
    }
}
