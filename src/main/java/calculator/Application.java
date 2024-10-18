package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String COMMA = ",";
    private static String SEMICOLON = ";";

    public static void main(String[] args) {
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        boolean isNotContainingDelimiter = !input.contains(COMMA) && !input.contains(SEMICOLON);

        if (input.isEmpty()) {
            return 0;
        }
        if (isNotContainingDelimiter) {
            throw new IllegalArgumentException("구분자가 없습니다");
        }

        return 1;
    }
}
