package calculator.controller;

import calculator.constants.AppConstants;
import calculator.dto.UserExpressionDto;
import calculator.service.CalculatorService;
import calculator.view.UserView;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

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
        showResult();
    }

    private String getExpressionFromUser() {
        userView.showMessage(AppConstants.requestMessage);
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void showResult() {
        userView.showMessage(AppConstants.responseMessage + calculatorService.getExpressionResult());
    }

    private void saveUserExpression(String expression) {
        calculatorService.saveUserExpression(new UserExpressionDto(expression));
    }

}
