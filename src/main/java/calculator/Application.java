package calculator;

import calculator.controller.CalculatorManager;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        new CalculatorManager().run();
        Console.close();
    }
}
