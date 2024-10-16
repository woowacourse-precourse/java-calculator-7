package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {

    public void run() {
        Input input = new Input();
        Output output = new Output();

        String inputValue = input.readInput();

        Calculator calc = new Calculator(inputValue);

        int sum = calc.sum();

        output.printCalcResult(sum);
    }
}
