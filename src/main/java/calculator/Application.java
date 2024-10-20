package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }

        String[] exactNumbers = calculation.filterNumbers(input);
        int result = calculation.sumNumbers(exactNumbers);
        System.out.println("결과 : " + result);
    }
}
