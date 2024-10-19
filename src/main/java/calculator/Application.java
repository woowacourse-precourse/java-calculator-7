package calculator;

public class Application {
    public static void main(String[] args) {

        InputValidator validator = new InputValidator();
        StringAdder stringAdder = new StringAdder(validator);

        String input = ConsoleIO.getInput();
        int result = stringAdder.add(input);
        ConsoleIO.printResult(result);
    }
}
