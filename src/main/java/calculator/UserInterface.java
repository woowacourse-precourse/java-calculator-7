package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public static String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String request = Console.readLine();
        validateInput(request);
        return request;
    }

    private static void validateInput(String request) {
        if (request == null) {
            throw new IllegalArgumentException("잘못된 입력.");
        }
    }

}
