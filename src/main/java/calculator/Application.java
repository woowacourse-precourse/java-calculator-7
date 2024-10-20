package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        Calculator calculator = new Calculator();
        String input = consoleReader.readCalcLine();
        int result = calculator.calc(input);
        consoleWriter.writeCalcResult(result);
    }
}
