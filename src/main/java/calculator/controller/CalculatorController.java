package calculator.controller;

import java.math.BigInteger;
import java.util.List;

import calculator.model.Calculator;
import calculator.model.Command;
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
        Command command = Command.from(inputView.readCommand());
        List<Number> numbers = command.extractNumbers();
        BigInteger result = calculator.sum(numbers);
        outputView.printResult(result);
    }
}
