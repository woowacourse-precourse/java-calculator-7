package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
    }

    private static boolean isCustomDelimiterDefined(String input) {
        return input.startsWith("//") && (input.indexOf("\n") == input.indexOf("//") + 3);
    }

}
