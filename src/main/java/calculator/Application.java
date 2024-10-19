package calculator;

import calculator.controller.CalculateController;
import calculator.model.UserInput;
import calculator.service.CalculateService;
import calculator.view.UserView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        CalculateService calculateService = new CalculateService();
        UserView userView = new UserView();
        CalculateController controller = new CalculateController(userInput, calculateService, userView);

        controller.run();
    }
}
