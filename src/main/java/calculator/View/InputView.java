package calculator.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_SUM_STRING="덧셈할 문자열을 입력해 주세요.";

    public static String ask_sum_string(){
        System.out.println(ASK_SUM_STRING);
        return Console.readLine();
    }
}
