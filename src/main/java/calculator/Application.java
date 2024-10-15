package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculator.calculate(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return 1; // 빈문자열이 아닐 떄 임시 리턴값
    }
}