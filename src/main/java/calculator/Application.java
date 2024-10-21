package calculator;

import calculator.controller.Calculator;
import calculator.model.StringAdder;
import calculator.model.StringType;
import calculator.viewer.CalculatorViewer;

public class Application {
    public static void main(String[] args) {
        StringAdder stringAdder = new StringAdder();
        CalculatorViewer calculatorViewer = new CalculatorViewer();
        StringType stringType = new StringType();

        Calculator calculator = new Calculator(stringAdder, calculatorViewer, stringType);
        calculator.runCalculator();
    }
}
