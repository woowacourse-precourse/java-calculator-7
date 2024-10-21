package calculator;

public class ApplicationController {

    public void run() {
        String input = InputHandler.getInput();
        String delimiter = DelimiterParser.getDelimiter(input);
        String numbers = DelimiterParser.extractNumbers(input);
        int[] parsedNumbers = NumberParser.parse(numbers, delimiter);
        int result = Calculator.sum(parsedNumbers);

        OutputHandler.displayResult(result);
    }
}
