package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Calculator calculator = new Calculator();

        calculator.run(inputHandler, outputHandler);
    }
}
