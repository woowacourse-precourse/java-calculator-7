package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.requestAdditionNumbers();
        List<Integer> additionNumbers = inputView.getAdditionNumbers();

        int result = additionNumbers.stream()
                .reduce(0, Integer::sum);
    }
}
