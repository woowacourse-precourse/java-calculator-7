package calculator;
import calculator.controller.Calculator;
import calculator.view.UserView;


public class Application {
    public static void main(String[] args) {
        UserView userView = new UserView(new Calculator());
        userView.run();
    }
}
