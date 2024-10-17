package calculator.view;

public interface ApplicationView {

    String requestValue();

    void printResult(int result);

    void printError(String message);
}
