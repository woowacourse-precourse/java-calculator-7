package calculator.adapters.output;

import calculator.application.ports.output.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
