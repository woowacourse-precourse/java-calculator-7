package calculator;

import calculator.controller.ConsoleController;
import calculator.controller.UserController;
import calculator.service.UserExpressionService;
import calculator.service.UserExpressionServiceImpl;
import calculator.view.ConsoleView;
import calculator.view.UserView;

public class AppConfig {

    public UserController userController() {
        return new ConsoleController(expressionService(), userView());
    }

    public UserExpressionService expressionService() {
        return new UserExpressionServiceImpl();
    }

    public UserView userView() {
        return new ConsoleView();
    }
}
