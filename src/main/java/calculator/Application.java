package calculator;

import calculator.adapter.in.console.ConsoleHandler;
import calculator.application.service.CalculateService;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        ConsoleHandler handler = new ConsoleHandler(new CalculateService());

        handler.calculateFromLine();
    }
}
