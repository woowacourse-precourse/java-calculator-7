package calculator.domain;

import calculator.input.InputHandler;
import calculator.output.OutputHandler;

public class CalculationManager {

    public void run() {
        String input = handleInput();

        SumCalculator sumCalculator = processCalculation(input);

        handleOutput(sumCalculator);
    }

    private String handleInput() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        return inputHandler.input();
    }

    private SumCalculator processCalculation(String input) {
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();
        return sumCalculator;
    }

    private void handleOutput(SumCalculator sumCalculator) {
        OutputHandler outputHandler = new OutputHandler(sumCalculator);
        outputHandler.output();
    }
}
