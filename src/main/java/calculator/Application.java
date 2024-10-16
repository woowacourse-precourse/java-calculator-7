package calculator;

import calculator.domain.Calculator;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("1,2:3");
        int sum = calculator.sum();
        System.out.println(sum);
    }

}
