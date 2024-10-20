package calculator;


import controller.CalculatorController;
import model.SaveTokens;
import view.UserInputView;
import view.UserOutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputView userInputView = new UserInputView();
        UserOutputView userOutputView = new UserOutputView();
        SaveTokens saveTokens = new SaveTokens();

        CalculatorController controller = new CalculatorController(userInputView, userOutputView, saveTokens);
        controller.run();
    }
}