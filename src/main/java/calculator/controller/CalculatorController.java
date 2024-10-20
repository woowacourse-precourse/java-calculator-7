package calculator.controller;

import calculator.model.Formula;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        String userInput = inputView.newlineInput("덧셈할 문자열을 입력해 주세요.");
        Formula formula = new Formula(userInput);
        outputView.printMessageWithNumber("결과 : ", formula.calculate());
    }
}
