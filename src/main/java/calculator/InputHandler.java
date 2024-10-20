package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.view.InputPrint;

public class InputHandler {
    public String getUserInput() {
        InputPrint.printInput();
        return readLine();
    }
}

