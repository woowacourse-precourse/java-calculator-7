package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = 0;
        if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            char customSeparator = input.charAt(2);
            for (int i = 5; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == customSeparator) {
                    continue;
                } else if (Character.isDigit(ch)) {
                    result += Character.getNumericValue(ch);
                }
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == ',' || ch == ':') {
                    continue;
                } else if (Character.isDigit(ch)) {
                    result += Character.getNumericValue(ch);
                }
            }
        }

        System.out.println("결과 : " + result);

    }
}
