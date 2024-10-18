package calculator.domain;

import calculator.output.OutputHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final OutputHandler outputHandler;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;

    public CalculationManager(InputView inputView, OutputView outputView,
                              OutputHandler outputHandler,
                              Delimiter delimiter,
                              CustomDelimiter customDelimiter,
                              NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.outputHandler = outputHandler;
        this.delimiter = delimiter;
        this.customDelimiter = customDelimiter;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String input = handleInput();
        processCalculation(input);
        handleOutput();
    }

    private String handleInput() {
        outputView.displayInputPrompt();
        return inputView.input();
    }

    private void processCalculation(String input) {
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();
    }

    private void handleOutput() {
        outputHandler.output();
    }
}
