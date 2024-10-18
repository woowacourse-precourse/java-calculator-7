package calculator.controller;

import java.math.BigInteger;
import java.util.List;

import calculator.model.Calculator;
import calculator.model.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    InputView inputView;
    OutputView outputView;
    Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        List<Number> numbers = inputView.readNumbers();
        BigInteger result = calculator.sum(numbers);
        outputView.printResult(result);
    }
}
