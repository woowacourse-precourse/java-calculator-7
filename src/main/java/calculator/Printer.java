package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Printer {
    public String write() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void read(int n) {
        System.out.println("결과 : " + n);
    }
}
