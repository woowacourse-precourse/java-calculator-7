package calculator;

import calculator.io.ConsoleIO;
import calculator.io.IO;
import calculator.operands.Operands;
import calculator.operands.PositiveIntegerOperands;

public class Application {
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        String input = io.read();

        Parser parser = new Parser(input);
        Operands<Long> operands = parser.parseEquation(new PositiveIntegerOperands());

        io.write(operands.getData().toString());
    }
}
