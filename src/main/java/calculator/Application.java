package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String input = calculator.input();
        String basicProcess = calculator.basicSeparate(input);
        String customProcess = (calculator.customSeparate(basicProcess));
        calculator.calculationResult(customProcess);
    }
}
