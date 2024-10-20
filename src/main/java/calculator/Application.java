package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Parser parser = new Parser();
        Calculator calculator = new Calculator();

        String input =  inputHandler.readInput();
        int[] intArray = parser.parseInput(input);
        int result = calculator.add(intArray);
        outputHandler.printValue(result);
    }
}
