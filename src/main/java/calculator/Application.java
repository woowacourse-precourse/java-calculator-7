package calculator;

import calculator.runner.CalculateRunner;

public class Application {
    public static void main(String[] args) {

        CalculateRunner runner = CalculateRunner.getInstance();

        runner.run();
    }
}
