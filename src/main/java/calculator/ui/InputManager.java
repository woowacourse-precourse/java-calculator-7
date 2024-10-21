package calculator.ui;

public class InputManager {

    private final InputView inputView;
    private final OutputView outputView;

    public InputManager(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getAddValue() {
        outputView.printAddMessage();
        return inputView.readValue();
    }
}
