package calculator;

import calculator.adapter.in.console.ConsoleHandler;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        ConsoleHandler handler = new ConsoleHandler(
                /* Todo: CalculateUseCase 인터페이스의 구현체가 들어온다. */
                null
        );

        handler.calculateFromLine();
    }
}
