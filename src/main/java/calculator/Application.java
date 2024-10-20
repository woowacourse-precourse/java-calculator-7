package calculator;


import controller.CalculatorController;
import view.UserInputView;
import view.UserOutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputView userInputView = new UserInputView();
        UserOutputView userOutputView = new UserOutputView();

        CalculatorController controller = new CalculatorController(userInputView, userOutputView);
        controller.run();
    }
}