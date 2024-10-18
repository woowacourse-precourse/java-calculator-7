package calculator.Controller;

import calculator.Model.AdditionCalculator;
import calculator.Model.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputProcessor inputProcessor = new InputProcessor();
    private final AdditionCalculator additionCalculator = new AdditionCalculator();

    public void run() {
        String input = inputView.getInput();
        int[] numbers = inputProcessor.processInput(input);
        int additionResult = additionCalculator.add(numbers);
        outputView.printOutput(additionResult);
    }
}
