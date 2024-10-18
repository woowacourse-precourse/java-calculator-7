package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.calculator.Delimiter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(new Delimiter());
        calculator.plusOperation();
    }
}
