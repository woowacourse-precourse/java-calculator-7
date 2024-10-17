package calculator;

import calculator.separator.CustomSeparatorManager;
import calculator.separator.Separators;
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

        Separators separators = Separators.withDefault()
                .merge(customSeparatorManager.findAllCustomSeparators(input));

        input = customSeparatorManager.sliceCustomSeparators(input);

        List<String> inputs = separators.split(input);
        int sum = Calculator.calculate(inputs);

        outputView.printResult(sum);
    }
}
