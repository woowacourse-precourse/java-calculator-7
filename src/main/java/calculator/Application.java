package calculator;

import calculator.adapter.in.console.ConsoleHandler;
import calculator.config.ApplicationContext;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        ApplicationContext context = ApplicationContext.fromEntry(Application.class);

        ConsoleHandler handler = context.getBean(ConsoleHandler.class);

        handler.calculateFromLine();
    }
}
