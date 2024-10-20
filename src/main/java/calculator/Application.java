package calculator;

import calculator.calculatorApplication.Calculator;
import calculator.calculatorApplication.CalculatorApplication;
import calculator.calculatorApplication.InputReader;
import calculator.calculatorApplication.OutputPrinter;
import calculator.factory.CalculatorFactory;
import calculator.factory.IOFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputReader inputReader = IOFactory.createInputReader();
        OutputPrinter outputPrinter = IOFactory.createOutputPrinter();
        Calculator calculator = CalculatorFactory.createCalculator();

        CalculatorApplication calculatorApplication = new CalculatorApplication(inputReader, outputPrinter, calculator);
        calculatorApplication.run();
    }
}
