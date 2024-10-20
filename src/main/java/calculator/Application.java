package calculator;

import calculator.service.NumberService;
import calculator.ui.ResultMessage;
import calculator.ui.UiInitializer;
import calculator.ui.UserInputInterface;
import calculator.ui.UserInputMessage;
import calculator.ui.UserOutputInterface;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final UiInitializer uiInitializer = new UiInitializer();
        final UserInputInterface userInputInterface = uiInitializer.initInputInterface();
        final UserOutputInterface userOutputInterface = uiInitializer.initOutputInterface();

        userOutputInterface.printInputInformation();
        final UserInputMessage inputMessage = userInputInterface.getUserInputMessage();
        final NumberService numberService = new NumberService();
        final String result = numberService.doService(inputMessage);
        userOutputInterface.printResult(new ResultMessage(result));
    }
}