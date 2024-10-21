package calculator;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final static String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
    private final static String OUTPUT_STRING = "결과 : %d";

    public String input() {
        System.out.println(INPUT_STRING);
        return Console.readLine();
    }

    public void output(Integer answer) {
        String result = String.format(OUTPUT_STRING, answer);
        System.out.println(result);
    }
}
