package calculator;

import calculator.calculator.Calculator;
import calculator.input.Input;
import calculator.output.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printInputMessage();

        Calculator calculator = new Calculator();
        int result = calculator.add(Input.getInputString());

        Output.printResult(result);
    }
}
