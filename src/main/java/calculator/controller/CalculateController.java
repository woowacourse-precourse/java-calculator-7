package calculator.controller;

import calculator.model.UserInput;
import calculator.service.CalculateService;
import calculator.view.UserView;

public class CalculateController {

    private UserInput userInput;
    private UserView userView;
    private CalculateService calculateService;

    public CalculateController(UserInput userInput, CalculateService calculateService, UserView userView) {
        this.userInput = userInput;
        this.calculateService = calculateService;
        this.userView = userView;
    }

    public void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = userInput.getInput();

        int result = calculateService.calculate(input);

        userView.printOutput(result);
    }
}
