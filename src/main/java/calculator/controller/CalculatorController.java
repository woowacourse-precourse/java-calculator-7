package calculator.controller;

import calculator.domain.StringParser;
import calculator.dto.AdditionInput;
import calculator.dto.ParsedComponents;
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
            return;
        }

        StringParser stringParser = new StringParser(validatedInput);
        ParsedComponents parsedComponents = stringParser.parse();
    }
}