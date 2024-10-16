package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.calculator.Prompt;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> strings = calculator.extractInteger("1,2:3");
        System.out.println(strings.toString());
    }

}
