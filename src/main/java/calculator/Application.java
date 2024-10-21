package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 수를 입력해주세요.");
        String input = Console.readLine();
        try {
            int result = Calculator.calculate(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println();
        }
    }


}