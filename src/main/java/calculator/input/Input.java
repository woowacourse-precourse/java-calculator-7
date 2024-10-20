package calculator.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static String INPUTMESSAGE = "덧셈할 문자열을 입력해 주세요";

    private void printInputMessage(){
        System.out.println(INPUTMESSAGE);
    }

    private String getUserMessage(){
        return readLine();
    }
}
