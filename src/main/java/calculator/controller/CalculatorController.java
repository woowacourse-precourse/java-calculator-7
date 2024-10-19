package calculator.controller;

import calculator.dto.AdditionInput;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        OutputView.printAdditionInputPrompt();
        AdditionInput additionInput = InputView.readAdditionInput();
        String validatedInput = additionInput.input();

        if (validatedInput.isEmpty()) {
            OutputView.printDefaultResult();
            run();
        }

    }
}