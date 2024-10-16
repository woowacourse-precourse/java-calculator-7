package calculator;

import calculator.controller.Controller;
import calculator.service.Calculator;
import calculator.service.Separator;
import calculator.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Separator separator = new Separator();
        Calculator calculator = new Calculator();
        Controller controller = new Controller(view, separator, calculator);
        controller.run();
    }
}
