package calculator;

import calculator.executor.Calculator;
import calculator.provider.ConsoleOperandsProvider;

public class Application {
    public static void main(String[] args) {
        ConsoleOperandsProvider provider = new ConsoleOperandsProvider();
        Calculator calculator = new Calculator(provider);
        calculator.enter();
        Long sum = calculator.addAll();
        System.out.printf("결과 : %d", sum);
    }
}
