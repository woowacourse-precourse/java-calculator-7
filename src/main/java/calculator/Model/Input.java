package calculator.Model;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String consoleInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawText = Console.readLine();

        if (rawText.length() == 0) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다. 공백은 허용되지 않습니다.");
        }

        return rawText;
    }
}
