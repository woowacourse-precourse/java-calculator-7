package calculator.controller;

import calculator.view.Users;

public class InputController {

    private String filterVacantInput() {
        String input = Users.input();
        return input.isEmpty() ? "0" : input;
    }
}
