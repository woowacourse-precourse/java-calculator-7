package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            input();
            int result = add();
            System.out.println("결과 : " + result);
        } catch(IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
        }
    }

    public void input() {
        String expr = Console.readLine();

    }

    public int add() {
        int sum = 0;

        return sum;
    }
}
