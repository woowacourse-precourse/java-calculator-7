package calculator;

import calculator.controller.Controller;
import calculator.service.DelimiterExtractor;
import calculator.service.NumberCalculator;
import calculator.service.StringParser;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new DelimiterExtractor(), new StringParser(), new NumberCalculator());
        controller.run();
    }
}
