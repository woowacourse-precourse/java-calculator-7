package calculator;

import calculator.calculator.SumCalculator;
import calculator.calculator.utils.NumberExtractor;
import calculator.io.ConsoleIOHandler;
import calculator.io.IOHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberExtractor extractor = new NumberExtractor();
        SumCalculator sumCalculator = new SumCalculator(extractor);
        IOHandler handler = new ConsoleIOHandler();

        Calculator calculator = new Calculator(sumCalculator, handler);
        try {
            calculator.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
