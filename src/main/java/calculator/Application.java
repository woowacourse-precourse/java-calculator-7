package calculator;

import calculator.service.NumberService;
import calculator.ui.ResultMessage;
import calculator.ui.UiInitializer;
import calculator.ui.UserInputController;
import calculator.ui.UserInputMessage;
import calculator.ui.UserOutputController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final UiInitializer uiInitializer = new UiInitializer();
        final UserInputController userInputController = uiInitializer.initInputController();
        final UserOutputController userOutputController = uiInitializer.initOutputController();

        userOutputController.printInputInformation();
        final UserInputMessage inputMessage = userInputController.getUserInputMessage();
        final NumberService numberService = new NumberService();
        final String result = numberService.doService(inputMessage);
        userOutputController.printResult(new ResultMessage(result));
    }
}