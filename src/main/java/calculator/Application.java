package calculator;

import calculator.utils.Splitter;

public class Application {
    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        Validator validator = new Validator();
        StringSumCalculator stringSumCalculator = new StringSumCalculator();
        Calculator calculator = new Calculator(splitter, validator, stringSumCalculator);

        calculator.run();
    }
}
