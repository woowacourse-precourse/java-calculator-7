package calculator;

public class Application {
    public static void main(String[] args) {

        InputOutputHandler inputOutputHandler = new InputOutputHandler();
        DelimiterHandler delimiterHandler = new DelimiterHandler();

        Calculator calculator = new Calculator(delimiterHandler);

        String input = inputOutputHandler.getInput();
        int result = calculator.calculate(input);
        inputOutputHandler.printResult(result);
    }
}
