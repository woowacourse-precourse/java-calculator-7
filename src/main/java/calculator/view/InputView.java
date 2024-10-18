package calculator.view;

import calculator.view.console.ConsoleReader;
import calculator.view.console.ConsoleWriter;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String enterString() {
        ConsoleWriter.printlnMessage(START_MESSAGE);
        return ConsoleReader.enterMessage();
    }
}
