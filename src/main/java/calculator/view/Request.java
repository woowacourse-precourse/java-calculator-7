package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Request {

    // 문자열 입력
    public static String inputPlusCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
