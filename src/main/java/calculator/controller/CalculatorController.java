package calculator.controller;

import calculator.domain.InputInfo;
import calculator.view.CalculatorView;
import java.math.BigInteger;
import java.util.List;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private InputInfo inputInfo;

    public CalculatorController() {
        this.calculatorView = new CalculatorView();
    }

    public BigInteger add() {
        List<BigInteger> numbers = inputInfo.getNumbers();
        if (numbers.isEmpty()) {
            return BigInteger.ZERO;
        }
        return numbers.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    public void run() {
        calculatorView.printInputMessage();
        String input = calculatorView.getInput();
        inputInfo = new InputInfo(input);
        BigInteger result = add();
        calculatorView.printResult(result);
    }
}
