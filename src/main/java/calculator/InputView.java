package calculator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String START_CALCULATE = "덧셈할 문자열을 입력해 주세요.";
    private final String input;

    public InputView() {
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }

    private void closedConsole(){
        Console.close();
    }
}
