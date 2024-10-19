package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorIO {
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); // 입력 받은 문자열 반환
    }

    public void output(int result) {
        System.out.println("결과 : " + result);
    }
}
