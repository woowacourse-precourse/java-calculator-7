package calculator;

import calculator.controller.CalculatorController;
import calculator.view.UserView;

public class Application {

    public static void main(String[] args) {
        UserView userView = new UserView(new CalculatorController());
        userView.run();
    }
}
