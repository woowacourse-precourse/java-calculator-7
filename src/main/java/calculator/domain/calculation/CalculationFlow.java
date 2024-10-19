package calculator.domain.calculation;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationFlow {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculationProcessor calculationProcessor;

    public CalculationFlow(InputView inputView, OutputView outputView, CalculationProcessor calculationProcessor) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculationProcessor = calculationProcessor;
    }

    public void run() {
        outputView.displayInputPrompt();
        String input = inputView.getInput();
        int calculatedResult = calculationProcessor.process(input);
        outputView.displayResult(calculatedResult);
    }
}
