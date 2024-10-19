package calculator;

import calculator.processor.Processor;
import calculator.ui.Calculator;

public class Application {
    public static void main(String[] args) {
        new Calculator(new Processor()).run();
    }
}
