package calculator.adapters.output.cli;

import calculator.ports.output.OutputPort;

public class CliOutputAdapter implements OutputPort {

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
