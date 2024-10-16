package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        while (true) {
            // 빈 문자열, 엔터, 탭, null 입력
            if (input.isBlank() || input == null) {
                System.out.println("결과 : " + sum);
                break;
            }

            // 단일 숫자 입력
            if (isInteger(input)) {
                System.out.println("결과 : " + input);
                break;
            }
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
