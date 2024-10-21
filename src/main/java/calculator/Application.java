package calculator;

import calculator.model.MainCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainCalculator mainCalculator = CalculatorFactory.createCalculator();
        mainCalculator.run();
    }
}
