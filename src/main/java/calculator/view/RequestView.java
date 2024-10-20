package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class RequestView {

    private static final RequestView INSTANCE = new RequestView();
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private RequestView() {
    }

    public static RequestView getInstance() {
        return INSTANCE;
    }

    public String readLine() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
