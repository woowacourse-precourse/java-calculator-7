package calculator;

public class Application {
    public static void main(String[] args) {

        ConsoleIO consoleIO = new ConsoleIO();
        InputValidator validator = new InputValidator();
        StringAdder stringAdder = new StringAdder(consoleIO, validator);

        String input = consoleIO.getInput();
        int result = stringAdder.add(input);
        consoleIO.printResult(result);
    }
}
