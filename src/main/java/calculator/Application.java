package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        Calculator calculator = new BasicCalculator(input);
        int result = calculator.calculate("add");
        System.out.println("결과 : " + result);
    }
}
