package calculator.Controller;

import calculator.Model.AdditionCalculator;
import calculator.Model.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final InputProcessor inputProcessor;
    private final AdditionCalculator additionCalculator;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, InputProcessor inputProcessor,
                                AdditionCalculator additionCalculator, OutputView outputView) {
        this.inputView = inputView;
        this.inputProcessor = inputProcessor;
        this.additionCalculator = additionCalculator;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.getInput();
        int[] numbers = inputProcessor.processInput(input);
        int additionResult = additionCalculator.add(numbers);
        outputView.printOutput(additionResult);
    }
}
