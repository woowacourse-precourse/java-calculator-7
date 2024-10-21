package calculator;

import camp.nextstep.edu.missionutils.Console;

public class In {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private In() {
        // 유틸리티 클래스의 인스턴스화 방지
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값이 비어있습니다.");
        }
    }
}