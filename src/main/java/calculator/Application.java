package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String userInput = inputHandler.getInput();

        Parser parser = new Parser();
        String[] parsedTokens = parser.parseInput(userInput);

        PositiveNumberValidator validator = new PositiveNumberValidator();
        int[] validatedNumbers = validator.validateNumber(parsedTokens);

        SumCalculator calculator = new SumCalculator();
        int result = calculator.calculateSum(validatedNumbers);

        Printer printer = new Printer();
        printer.printResult(result);
    }
}

