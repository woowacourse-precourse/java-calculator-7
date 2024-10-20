package calculator;

import calculator.common.RequestType;
import calculator.processor.Processor;
import calculator.ui.Calculator;

public class Application {

    public static void main(String[] args) {
        new Calculator(new Processor()).command(RequestType.SUM);
    }
}
