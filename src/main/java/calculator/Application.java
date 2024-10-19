package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private final CalculatorController calculatorController;

    public Application() {
        this.calculatorController = new CalculatorController();
    }

    public static void main(String[] args) {
        Application app = new Application();

        String greeting = app.calculatorController.greeting();
        System.out.println(greeting);

        String input = Console.readLine();
        app.calculatorController.calculate(input);
    }
}
