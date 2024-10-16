package calculator;

import calculator.delimiter.factory.DelimiterHandlerFactory;
import calculator.input.InputContext;
import calculator.input.strategy.ConsoleInputStrategy;
import calculator.output.OutputContext;
import calculator.output.strategy.ConsoleOutputStrategy;

public class Application {
    public static void main(String[] args) {
        InputContext inputContext = new InputContext(new ConsoleInputStrategy());
        OutputContext outputContext = new OutputContext(new ConsoleOutputStrategy());
        DelimiterHandlerFactory factory = new DelimiterHandlerFactory();

        String input = inputContext.execute();
        Calculator calculator = new Calculator(factory);

        outputContext.execute(String.valueOf(calculator.sum(input)));
    }
}
