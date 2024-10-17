package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        System.out.println("입력된 문자열 : " + inputString);

        String customDelimiter = getCustomDelimiter(inputString);
        System.out.println("커스텀 구분자 : " + (customDelimiter == null ? "없음" : customDelimiter));
    }

    private static String getCustomDelimiter(String string) {
        String customDelimiterOpener = "//";
        String customDelimiterCloser = "\\n";

        if (string.length() < 5) {
            return null;
        }
        if (!string.substring(0, 2).equals(customDelimiterOpener) || !string.substring(3, 5).equals(customDelimiterCloser)) {
            return null;
        }
        return string.substring(2, 3);
    }
}
