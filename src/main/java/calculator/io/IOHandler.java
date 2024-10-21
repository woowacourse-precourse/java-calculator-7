package calculator.io;

public interface IOHandler {

    void startMessage();

    String getUserInput();

    void showResult(int result);
}
