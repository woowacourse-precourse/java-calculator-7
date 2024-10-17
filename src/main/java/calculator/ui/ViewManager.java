package calculator.ui;

public class ViewManager {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public String userInput() {
        return inputView.input();
    }

    public void output(int result) {
        outputView.output(result);
    }
}
