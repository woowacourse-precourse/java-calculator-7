package calculator;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        OutputHandler outputHandler = new OutputHandler();

        String input = inputHandler.getInput();
        int result = calculator.separateInput(input);
        outputHandler.printResult(result);
    }
}