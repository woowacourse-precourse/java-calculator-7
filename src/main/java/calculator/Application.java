package calculator;

import calculator.core.Calculator;
import calculator.core.LongCalculator;

public class Application {
    public static void main(String[] args) {
        Calculator myCalculator = new LongCalculator();
        myCalculator.startCalculation();
    }
}
