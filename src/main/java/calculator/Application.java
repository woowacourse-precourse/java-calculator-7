package calculator;

public class Application {
    public static void main(String[] args) {
        String input = InputHandler.getInput();
        String[] numbers = DelimeterParser.parse(input);
        // OutputHandler.printResult(result);
    }
}
