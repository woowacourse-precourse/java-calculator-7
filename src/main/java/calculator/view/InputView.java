package calculator.view;

import calculator.util.CommonIO;

public class InputView {
    private final CommonIO io;

    public InputView() {
        this.io = new CommonIO();
    }

    public String InputData() {
        return io.receiveInput();
    }
}
