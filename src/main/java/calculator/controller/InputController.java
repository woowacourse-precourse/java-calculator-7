package calculator.controller;

import calculator.domain.UserExpression;
import calculator.view.Users;

public class InputController {

    private UserExpression userExpression;

    public UserExpression input() {
        comesNewInput();
        return userExpression;
    }

    public void comesNewInput() {
        userExpression = new UserExpression(filterVacantInput());
    }

    private String filterVacantInput() {
        String input = Users.input();
        return input.isEmpty() ? "0" : input;
    }
}
