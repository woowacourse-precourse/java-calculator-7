package calculator.controller;

import calculator.constants.AppConstants;
import calculator.dto.UserExpressionDto;
import calculator.service.UserExpressionService;
import calculator.view.UserView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleController implements UserController {
    private final UserExpressionService userExpressionService;
    private final UserView userView;

    public ConsoleController(UserExpressionService userExpressionService, UserView userView) {
        this.userExpressionService = userExpressionService;
        this.userView = userView;
    }

    @Override
    public void run() {
        String expression = getExpressionFromUser();
    }

    private String getExpressionFromUser() {
        userView.showMessage(AppConstants.requestMessage);
        return Console.readLine();
    }

    private void saveUserExpression(String expression) {
        userExpressionService.saveUserExpression(new UserExpressionDto(expression));
    }


}
