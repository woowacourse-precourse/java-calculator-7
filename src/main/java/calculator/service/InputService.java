package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String enterInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
