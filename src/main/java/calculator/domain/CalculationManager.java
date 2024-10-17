package calculator.domain;

import calculator.input.InputHandler;
import calculator.output.OutputHandler;

public class CalculationManager {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;

    public CalculationManager(InputHandler inputHandler,
                              OutputHandler outputHandler,
                              Delimiter delimiter,
                              CustomDelimiter customDelimiter,
                              NumberGenerator numberGenerator) {
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
        inputHandler.showMessage();
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
