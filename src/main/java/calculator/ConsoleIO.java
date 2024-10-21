package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자의 문자열 입력을 받고 결과를 출력하는 클래스
 */
public class ConsoleIO {
    private static final String INPUTMSG = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUTMSG = "결과 : ";

    public static String getInput() {
        System.out.println(INPUTMSG);
        return Console.readLine();
    }
}
