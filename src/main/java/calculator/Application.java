package calculator;

import calculator.io.ConsoleIO;
import calculator.io.ConsoleReader;
import calculator.io.Writer;
import calculator.parser.Parser;

public class Application {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO(new ConsoleReader(), new Writer());

        String expression = console.readExpression();

        Calculator calculator = new Calculator(new Parser());
        int result = calculator.calculate(expression);

        console.writeResult(result);
    }
}
