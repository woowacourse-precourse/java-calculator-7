package calculator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String START_CALCULATE = "덧셈할 문자열을 입력해 주세요.";
    private final String userInput;

    public InputView() {
        userInput = Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }

    private void closedConsole(){
        Console.close();
    }
}
