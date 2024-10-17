package calculator;

public interface ApplicationView {

    String requestValue();

    void printResult(String result);

    void printError(String message);
}
