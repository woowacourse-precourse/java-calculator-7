package calculator;

import java.util.Arrays;

public class Game {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Game() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void start() {
        String input = inputHandler.getUserInput();
        Separators separators = new Separators();

        String processedInput = processInput(input, separators);
        int[] numbers = convertInputToNumbers(processedInput, separators);

        printResult(numbers);
    }

    private String processInput(String input, Separators separators) {
        return separators.containCustomSeparator(input);
    }

    private int[] convertInputToNumbers(String input, Separators separators) {
        Input inputProcessor = new Input(input);
        String[] splitStr = inputProcessor.splitBySeparator(separators);
        return inputProcessor.convertToIntArray(splitStr);
    }

    private void printResult(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        outputHandler.printResult(sum);
    }
}
