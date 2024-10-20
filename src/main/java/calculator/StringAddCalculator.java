package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringAddCalculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    private int calculate(String input) {
        return 0;
    }
}
