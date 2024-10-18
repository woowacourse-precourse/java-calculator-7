package calculator;

import calculator.separator.CustomSeparatorManager;
import calculator.separator.NumericString;
import calculator.separator.SeparatorCalculator;
import calculator.separator.Separators;
import calculator.view.InputView;
import calculator.view.OutputView;
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

        Separators separators = getSeparators(input);
        String inputWithoutCustomSeparators = customSeparatorManager.sliceCustomSeparators(input);
        NumericString result = SeparatorCalculator.sum(inputWithoutCustomSeparators, separators);

        outputView.printResult(result);
    }

    private Separators getSeparators(String input) {
        Separators customSeparators = customSeparatorManager.findAllCustomSeparators(input);

        return Separators.withDefault()
                .merge(customSeparators);
    }
}
