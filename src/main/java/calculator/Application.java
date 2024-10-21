package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        MessagePrinter messagePrinter = new MessagePrinter();
        StringSumCalculator stringSumCalculator = new StringSumCalculator();

        String input = inputHandler.calculateSumFromInput();

        int sum = stringSumCalculator.sumInString(input);

        messagePrinter.printResult(sum);
    }


}
