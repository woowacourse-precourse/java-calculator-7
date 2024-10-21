package calculator.controller;

import calculator.Calculator;
import calculator.UserInput;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    public void run() {
        OutputView.printStartMessage();
        UserInput userInput = new UserInput(InputView.readInputString());

        if (userInput.isInputEmpty()) {
            OutputView.printResult("결과 : " + 0);
            return;
        }

        List<Long> inputNumbers = userInput.parser(userInput.getInput());
        long result = new Calculator().sum(inputNumbers);

        OutputView.printResult("결과 : " + result);
    }
}
