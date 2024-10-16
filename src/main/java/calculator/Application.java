package calculator;

import calculator.controller.ProgramController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ProgramController programController = new ProgramController();
        programController.run();
        Console.close();
    }
}
