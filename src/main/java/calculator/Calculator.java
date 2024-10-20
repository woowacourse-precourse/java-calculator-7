package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    String expr;

    public void run() {
        boolean valid = input();
        if(valid) {
            int result = add();
            System.out.println("결과 : " + result);
        }
        else {
            System.out.println("올바르지 않은 입력입니다.");
        }
    }

    public boolean input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            expr = Console.readLine();
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }

    public int add() {
        return 0;
    }
}
