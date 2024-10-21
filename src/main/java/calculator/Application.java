package calculator;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.read();

        Delimiter delimiter = new Delimiter();
        String[] inputExceptForCustomDelimiterAndCustomDelimiter = delimiter.findDelimiter(input);
        String[] strings = delimiter.devisionString(inputExceptForCustomDelimiterAndCustomDelimiter);

        Calculator calculator = new Calculator();
        int sum = calculator.getSum(strings);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.print(sum);
    }
}
