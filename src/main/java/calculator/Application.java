package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        }
    }
}
