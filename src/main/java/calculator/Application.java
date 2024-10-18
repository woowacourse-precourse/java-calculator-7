package calculator;

import calculator.controller.Controller;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.calculate();
    }
}
