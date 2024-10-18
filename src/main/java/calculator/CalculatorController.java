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

        Separators separators = getSeparators(input);

        String inputWithoutCustomSeparators = customSeparatorManager.sliceCustomSeparators(input);
        NumericString sum = Adder.add(inputWithoutCustomSeparators, separators);

        outputView.printResult(sum);
    }

    private Separators getSeparators(String input) {
        return Separators.withDefault()
                .merge(customSeparatorManager.findAllCustomSeparators(input));
    }

    private List<String> split(String input, Separators separators) {
        input = customSeparatorManager.sliceCustomSeparators(input);
        return separators.split(input);
    }
}
