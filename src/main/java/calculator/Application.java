package calculator;

import calculator.controller.Controller;
import calculator.service.DelimiterExtractor;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new DelimiterExtractor());
        controller.run();
    }
}
