package calculator.controller;

import calculator.constants.AppConstants;
import calculator.dto.UserExpressionDto;
import calculator.service.CalculatorService;
import calculator.view.UserView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleController implements UserController {
    private final CalculatorService calculatorService;
    private final UserView userView;

    public ConsoleController(CalculatorService calculatorService, UserView userView) {
        this.calculatorService = calculatorService;
        this.userView = userView;
    }

    @Override
    public void run() {
        String expression = getExpressionFromUser();
        saveUserExpression(expression);
    }

    private String getExpressionFromUser() {
        userView.showMessage(AppConstants.requestMessage);
        return Console.readLine();
    }

    private void saveUserExpression(String expression) {
        calculatorService.saveUserExpression(new UserExpressionDto(expression));
    }


}
