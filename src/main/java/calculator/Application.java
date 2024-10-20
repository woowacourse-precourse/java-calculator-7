package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        StringCalculator calculator = new StringCalculator();
        int result = calculator.add(input);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(result);
    }
}
