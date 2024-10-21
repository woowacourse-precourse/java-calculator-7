package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printCalculatedOutput(long sum) {
        System.out.println("결과 : " + sum);
    }
}
