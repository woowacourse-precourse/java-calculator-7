package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputString () {
        System.out.println("문자열 덧셈계산기 입니다. 문자열을 규칙에 맞게 입력해주세요. ");
        return Console.readLine();
    }
}
