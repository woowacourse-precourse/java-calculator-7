package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;
    private final Operations operations;

    public Calculator(InputView inputView, OutputView outputView, Operations operations) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.operations = operations;
    }

    public void run() {
        List<Number> numbers = inputView.readNumbers();
        String result = operations.add(numbers);
        outputView.printResult(result);
    }
}
