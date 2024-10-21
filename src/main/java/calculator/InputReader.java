package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String promptForInput() {
        System.out.println(INPUT_MESSAGE);
        // 모든 공백을 빈 문자열로 대체하여 제거
        return Console.readLine().replaceAll("\\s+", "");
    }
}
