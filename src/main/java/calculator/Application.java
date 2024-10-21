package calculator;

import calculator.component.Calculator;
import calculator.util.CustomIO;

public class Application {
    public static void main(String[] args) {
        String expression = CustomIO.readLine();
        Integer result = Calculator.calculate(expression);
        System.out.println("결과 : " + result);
    }
}
