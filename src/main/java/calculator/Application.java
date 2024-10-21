package calculator;

import calculator.domain.Calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.run();
        System.out.println("결과 : " + result);
    }
}