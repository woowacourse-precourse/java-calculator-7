package calculator;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String inputGuidePhrases = "덧셈할 문자열을 입력해 주세요.";

    public static void printInputGuide() {
        System.out.println(inputGuidePhrases);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
