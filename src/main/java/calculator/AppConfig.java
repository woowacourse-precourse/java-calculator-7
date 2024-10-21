package calculator;

import calculator.controller.ConsoleController;
import calculator.controller.UserController;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.ConsoleView;
import calculator.view.UserView;

public class AppConfig {

    public UserController userController() {
        return new ConsoleController(calculatorService(), userView());
    }

    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }

    public UserView userView() {
        return new ConsoleView();
    }
}
