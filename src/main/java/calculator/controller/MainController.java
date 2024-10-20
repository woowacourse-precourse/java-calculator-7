package calculator.controller;

import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class MainController {

    public void start(){
        UserOutputView.printAddStartMessage();
        String userInput = UserInputView.readUserInput();
    }
}
