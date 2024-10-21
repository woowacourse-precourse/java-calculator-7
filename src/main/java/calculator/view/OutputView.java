package calculator.view;

import calculator.util.CommonIo;

public class OutputView {
    private final CommonIo io;

    public OutputView() {
        this.io = new CommonIo();
    }

    public void printMessage(String message) {
        io.printMessage(message);
    }
}
