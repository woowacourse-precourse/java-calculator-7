package calculator;

import calculator.domain.StringCalculator;
import calculator.view.Input;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(Input.input());

        System.out.println("결과 : " + result);
    }
}
