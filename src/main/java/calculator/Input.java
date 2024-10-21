package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String word;

    static {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        word = Console.readLine();
    }

    private static boolean isCustomDivision() {
        return word.startsWith("//") && word.contains("\\n");
    }

    public static String findCustomDivision() {
        if (isCustomDivision()) {
            int startIndex = 2;
            int endIndex = word.indexOf("\\n");
            return word.substring(startIndex, endIndex);
        }
        return null;
    }

    public static String numbers() {
        if (isCustomDivision()) {
            return word.substring(word.indexOf("\\n") + 2);
        }
        return word;
    }
}
