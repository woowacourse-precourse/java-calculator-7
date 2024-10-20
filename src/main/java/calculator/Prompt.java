package calculator;

public class Prompt {

    public void getCommand(Calculator calculator) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        outputHandler.printInitMessage();
        int[] numbers = inputHandler.getInput();
        int result = calculator.calculate(numbers);

        outputHandler.printResult(result);
    }
}
