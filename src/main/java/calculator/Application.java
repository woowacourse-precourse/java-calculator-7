package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 null이거나 빈 문자열이면 예외 발생
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
    }
}

