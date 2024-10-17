package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterChecker;
import calculator.io.input.ConsoleInputHandler;
import calculator.io.input.InputHandler;
import calculator.io.output.ConsoleOutputHandler;
import calculator.io.output.OutputHandler;
import calculator.operations.AdditionStrategy;
import calculator.operations.Calculator;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        DelimiterChecker delimiterChecker = new DelimiterChecker("//", "\n");
        Delimiter delimiter = new Delimiter(List.of(",", ":"));
        Calculator calculator = new Calculator(new AdditionStrategy());

        CalculatorApp calculatorApp = new CalculatorApp
                (inputHandler, outputHandler, delimiterChecker, delimiter, calculator);

        calculatorApp.run();
    }

}
