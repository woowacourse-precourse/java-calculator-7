package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public int run() {
        String input = getInput();
        return calculate(input);
    }

    // 문자열을 입력받는 함수
    private String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private int calculate(String input) {
        return 0;
    }
}
