package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String userInput = Console.readLine();
            StringCalculator calculator = new StringCalculator();
            long result = calculator.calculate(userInput);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 문자열을 입력하였습니다!!!");
        }
    }
}
