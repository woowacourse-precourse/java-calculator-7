package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NOTICE_INPUT_CONTEXT = "덧셈할 문자열을 입력해 주세요.";

    public static String inputString(){
        System.out.println(InputView.NOTICE_INPUT_CONTEXT);
        return Console.readLine();
    }
}
