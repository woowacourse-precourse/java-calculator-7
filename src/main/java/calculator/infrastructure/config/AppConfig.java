package calculator.infrastructure.config;

import calculator.view.input.InputReader;
import calculator.view.input.InputReaderImpl;
import calculator.view.output.OutputWriter;
import calculator.view.output.OutputWriterImpl;

public class AppConfig {

    private InputReader inputReader;
    private OutputWriter outputWriter;

    public InputReader inputReader() {
        if (inputReader == null) {
            inputReader = new InputReaderImpl();
        }

        return inputReader;
    }

    public OutputWriter outputWriter() {
        if (outputWriter == null) {
            outputWriter = new OutputWriterImpl();
        }

        return outputWriter;
    }

}
