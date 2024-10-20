package calculator.io.outputPrinter;

import calculator.calculatorApplication.OutputPrinter;

public class ConsoleOutputPrinter implements OutputPrinter {

    @Override
    public void println(String input) {
        System.out.println(input);
    }
}
