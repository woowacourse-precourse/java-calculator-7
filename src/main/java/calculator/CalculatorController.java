package calculator;

import calculator.delimiter.CustomSeparatorManager;
import calculator.delimiter.Separators;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;
import java.util.Objects;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CustomSeparatorManager customSeparatorManager;

    public CalculatorController(InputView inputView,
                                OutputView outputView,
                                CustomSeparatorManager customSeparatorManager) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
        this.customSeparatorManager = Objects.requireNonNull(customSeparatorManager);
    }

    public void calculate() {
        String input = inputView.inputString();

        Separators separators = Separators.createCalculatorSeparators();

        while (customSeparatorManager.add(input, separators)) {
            input = customSeparatorManager.extractAfterCustomSeparator(input);
        }

        List<String> inputs = separators.separate(input);
        int sum = Calculator.calculate(inputs);
        outputView.printResult(sum);
    }
}
