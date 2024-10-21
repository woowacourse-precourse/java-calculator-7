package calculator;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        String input = InputHandler.readInput();

        BigInteger result = Calculator.calculate(Parser.parse(input));

        OutputHandler.printOutput(result);
    }
}
