package calculator;

import calculator.controller.StringCalculatorController;
import calculator.view.ConsoleView;


public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        StringCalculatorController controller = new StringCalculatorController(view);
        controller.run();
    }
}
