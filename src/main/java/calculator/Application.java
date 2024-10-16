package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        final String input = input();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }


    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static void splitInput() {

    }

    private static boolean isNumber(String str) {
        try {
            long l = Long.parseLong(str);
            return l > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

