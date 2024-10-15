package calculator;

import calculator.StringCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        StringCalculator calculator = new StringCalculator();
        try {
            Integer sum = calculator.calculate(input);
            System.out.println("결과 : " + sum.toString());
        } catch (IllegalArgumentException e) {
            throw e;
        }


    }
}
