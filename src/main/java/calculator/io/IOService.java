package calculator.io;

public interface IOService {

    String getInput();

    void printResult(long result);

    void close();

}
