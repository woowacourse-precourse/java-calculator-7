package calculator;

public class Application {
    public static void main(String[] args) {
        String input = InputHandler.readInput();
        int result = Calculator.calculate(Parser.parse(input));
        OutputHandler.printOutput(result);
    }
}
