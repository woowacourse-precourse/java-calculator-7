package calculator;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        IO io = new IO();
        String input = io.readInput();

        Validator validator = new Validator();
        StringTokenizer numbers = validator.inputValidCheck(input);

        Calculator calculator = new Calculator();
        long result = calculator.sum(numbers);

        io.printOutput(result);
    }
}