package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IO {

    public String receiveInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void sendOutput(long result) {
        System.out.println("결과 : " + result);
    }
}
