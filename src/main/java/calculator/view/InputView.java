package calculator.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ADDITION_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readUserInput() {
        return Console.readLine();
    }

    public void showInputMessage() {
        System.out.println(ADDITION_INPUT_MESSAGE);
    }
}
