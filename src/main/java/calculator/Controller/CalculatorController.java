package calculator.Controller;

import calculator.Model.AdditionCalculator;
import calculator.Model.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputProcessor inputProcessor = new InputProcessor();
    private final AdditionCalculator additionCalculator = new AdditionCalculator();

    public void run() {
        String input = InputView.getInput();
        long[] numbers = inputProcessor.processInput(input);
        long additionResult = additionCalculator.add(numbers);
        OutputView.printOutput(additionResult);
    }
}
