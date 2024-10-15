package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 사용자에게 입력 메시지를 출력합니다.
     */
    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    /**
     * 사용자에게 계산할 문자열을 입력 받습ㄴ디ㅏ.
     * @return 입력 받은 문자열
     */
    public static String getInput() {
        return Console.readLine();
    }

}
