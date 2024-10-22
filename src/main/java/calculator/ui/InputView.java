package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private final static String ERROR_MESSAGE = "잘못 입력하였습니다.";


    public String inputView() {
        System.out.println(INPUT_SENTENCE);
        String str = null;
        try {
            str = Console.readLine();
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE);
        }

        return str;
    }
}
