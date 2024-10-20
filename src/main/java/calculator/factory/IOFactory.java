package calculator.factory;

import calculator.calculatorApplication.InputReader;
import calculator.calculatorApplication.OutputPrinter;
import calculator.io.inputReader.ConsoleInputReader;
import calculator.io.outputPrinter.ConsoleOutputPrinter;

public class IOFactory {

    public static InputReader createInputReader() {
        return new ConsoleInputReader();
    }

    public static OutputPrinter createOutputPrinter() {
        return new ConsoleOutputPrinter();
    }

}
