package calculator;

import calculator.controller.Controller;
import calculator.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        new Controller(view);
    }
}
