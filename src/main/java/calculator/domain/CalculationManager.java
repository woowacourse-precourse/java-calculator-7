package calculator.domain;

import calculator.input.InputHandler;
import calculator.output.OutputHandler;
import calculator.view.OutputView;

public class CalculationManager {

    private final OutputView outputView;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;

    public CalculationManager(OutputView outputView, InputHandler inputHandler,
                              OutputHandler outputHandler,
                              Delimiter delimiter,
                              CustomDelimiter customDelimiter,
                              NumberGenerator numberGenerator) {
        this.outputView = outputView;
        this.inputHandler = inputHandler;
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
        return inputHandler.input();
    }

    private void processCalculation(String input) {
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();
    }

    private void handleOutput() {
        outputHandler.output();
    }
}
