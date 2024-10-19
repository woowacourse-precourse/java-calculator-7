package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String input;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        }
        else if (input.length() == 1 && isDigit((input.charAt(0)))) {
            System.out.println("결과 : " + input);
        }

    }
}
