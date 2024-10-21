package calculator;

import calculator.component.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String expression = Console.readLine();
        Integer result = Calculator.calculate(expression);
        System.out.println("결과 : " + result);
    }
}
