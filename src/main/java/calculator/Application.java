package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();

        calculatorController.run();
    }
}
