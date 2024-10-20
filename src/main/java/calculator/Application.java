package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String input = Console.readLine();

        try {
            int result = calculator.calc(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 : " + e.getMessage());
        }
    }
}