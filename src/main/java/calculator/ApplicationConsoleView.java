package calculator;

public class ApplicationConsoleView implements ApplicationView{

    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationConsoleView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public String requestValue() {
        outputView.requestInputValue();
        return inputView.inputValue();
    }

    @Override
    public void printResult(String result) {

    }

    @Override
    public void printError(String message) {

    }
}
