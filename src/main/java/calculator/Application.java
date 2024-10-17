package calculator;

import calculator.controller.CalculateController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        CalculateController calculateController = new CalculateController();

        calculateController.insertUserInput(userInput);

    }
}
