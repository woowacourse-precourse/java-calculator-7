package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /***
     * 사용자로부터 콘솔창을 통해 문자열을 입력받습니다.
     * @return : 입력받은 문자열을 반환합니다.
     */
    public String readInputString() {
        System.out.println(START_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.isBlank()) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }
        return Console.readLine();
    }
}
