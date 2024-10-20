package calculator;

public class Calculator {

    public void run(InputHandler inputHandler, OutputHandler outputHandler) {
        outputHandler.printInitMessage();

        int[] numbers = inputHandler.getInput();
        int result = calculate(numbers);

        outputHandler.printResult(result);
    }

    public int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
