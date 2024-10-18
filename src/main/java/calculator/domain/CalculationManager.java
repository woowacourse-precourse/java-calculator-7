package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;
    private final SumCalculator sumCalculator;

    public CalculationManager(InputView inputView, OutputView outputView,
                              Delimiter delimiter,
                              CustomDelimiter customDelimiter,
                              SumCalculator sumCalculator,
                              NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.sumCalculator = sumCalculator;
        this.delimiter = delimiter;
        this.customDelimiter = customDelimiter;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        displayInputPrompt();
        processCalculation();
        displayResultWithMessage();
    }

    private void displayInputPrompt() {
        String inputPrompt = outputView.getInputPrompt();
        System.out.println(inputPrompt);
    }

    private void processCalculation() {
        String input = inputView.input();
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();
    }

    private void displayResultWithMessage() {
        int result = sumCalculator.getResult();
        System.out.println(outputView.getFormattedResult(result));
    }

}
