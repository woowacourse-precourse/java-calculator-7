package calculator;

import calculator.utils.Splitter;

public class Application {
    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        Calculator calculator = new Calculator(splitter);

        calculator.run();
    }
}
