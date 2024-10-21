package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator calculator = new StringCalculator();
        while (true) {
            System.out.println("덧셈할 문자열을 입력해주세요.");
            try {
                String input = Console.readLine();
                int result = calculator.calculate(input);
                System.out.println("결과 : " + result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("오류 : " + e.getMessage());
                break;
            }
        }
    }
}
