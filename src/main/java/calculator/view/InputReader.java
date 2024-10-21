package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    // 사용자로부터 입력 처리
    public String readLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        return input;
    }
}