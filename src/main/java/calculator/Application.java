package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            StringCalculate calculator = new StringCalculate();
            System.out.println("덧셈할 문자열을 입력해 주세요. ");
            String input = Console.readLine();
//            int result = calculator.calculateDefault(input);
            int result2 = calculator.calculateCustom(input);
            System.out.println("결과 : " + result2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
