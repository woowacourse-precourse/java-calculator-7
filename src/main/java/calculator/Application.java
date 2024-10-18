package calculator;

import calculator.delimiter.filter.NegativeNumberValidationFilter;
import calculator.delimiter.filter.ValidationFilter;
import calculator.delimiter.handler.factory.DelimiterHandlerFactory;
import calculator.input.InputContext;
import calculator.input.strategy.ConsoleInputStrategy;
import calculator.output.OutputContext;
import calculator.output.strategy.ConsoleOutputStrategy;

public class Application {
    public static void main(String[] args) {
        InputContext inputContext = new InputContext(new ConsoleInputStrategy());
        OutputContext outputContext = new OutputContext(new ConsoleOutputStrategy());
        DelimiterHandlerFactory factory = new DelimiterHandlerFactory();

        ValidationFilter middleware = ValidationFilter.link(
                new NegativeNumberValidationFilter()
        );

        String input = inputContext.execute();
        Calculator calculator = new Calculator(factory, middleware);

        outputContext.execute(String.valueOf(calculator.sum(input)));
    }
}
