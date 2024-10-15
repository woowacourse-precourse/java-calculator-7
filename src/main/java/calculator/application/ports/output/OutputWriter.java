package calculator.application.ports.output;

public interface OutputWriter {

    void print(String message);

    void printLine(String message);
    void printNewLine();
}
