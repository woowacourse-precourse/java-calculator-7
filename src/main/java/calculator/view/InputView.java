package calculator.view;

import calculator.view.console.ConsoleReader;
import calculator.view.console.ConsoleWriter;

public class InputView {
    public String enterString() {
        return ConsoleReader.enterMessage();
    }
}
