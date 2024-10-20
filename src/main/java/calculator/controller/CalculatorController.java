package calculator.controller;

import calculator.model.Separator;
import calculator.model.UserInput;
import calculator.service.CalculatorService;
import calculator.service.InputService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();
    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        outputView.printStart();

        UserInput userInput = new UserInput(inputView.input());
        String[] inputSplit = inputService.findCustomSeparator(userInput.getUserInput());

        Separator separator = new Separator();

        if (inputSplit[0] != null) {
            separator.setCustomSeparator(inputSplit[0].substring(2));
        }

        inputService.handleInput(inputSplit, separator);

        String[] splitNumbers = inputService.splitSeparator(inputSplit[1], separator);

        int result = calculatorService.sumSplitNumbers(splitNumbers);

        outputView.printResult(result);
    }
}
