package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT = "덧셈할 문자열을 입력해 주세요.";
    public static InputView INSTANCE = new InputView();
    private InputView() {
    }
    public String read(){
        System.out.println(PROMPT);
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
