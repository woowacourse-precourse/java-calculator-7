package calculator;

import calculator.delimiter.factory.DelimiterHandlerFactory;
import calculator.output.OutputContext;
import calculator.output.strategy.ConsoleOutputStrategy;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        OutputContext output = new OutputContext(new ConsoleOutputStrategy());
        DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
        Calculator calculator = new Calculator(factory);
        output.execute(String.valueOf(calculator.sum(input)));
    }
}
