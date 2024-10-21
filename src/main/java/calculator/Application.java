package calculator;

import calculator.calculator.Calculator;
import calculator.calculator.Parser;
import calculator.input.InputReader;
import calculator.output.OutputViewer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputViewer.printStartMessage();

        Calculator calculator = new Calculator(new Parser());
        InputReader inputReader = new InputReader();

        int result = calculator.add(inputReader.getInput());

        OutputViewer.printResultMessage(result);
    }
}
