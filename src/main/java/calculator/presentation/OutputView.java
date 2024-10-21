package calculator.presentation;

public class OutputView {
    private final String prefix;

    public OutputView(String prefix) {
        this.prefix = prefix;
    }
    public void printResult(int result) {
        System.out.println(prefix + result);
    }
}
