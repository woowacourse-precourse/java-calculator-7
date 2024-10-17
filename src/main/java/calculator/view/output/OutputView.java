package calculator.view.output;

public interface OutputView {
    void printInputPrompt();
    void printResult(int result);
    void printError(String message);
}
