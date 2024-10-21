package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUTMESSAGE = "덧셈할 문자열을 입력해 주세요";

    public static void printInputMessage(){
        System.out.println(INPUTMESSAGE);
    }

    public static String getUserMessage(){
        return Console.readLine();
    }
}
