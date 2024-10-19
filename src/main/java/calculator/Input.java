package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    //    private static final Input INPUT = new Input();
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
//    private String input;

    public static String readInput() {
        System.out.println(INPUT_MESSAGE);
        return readLine();
    }
}
