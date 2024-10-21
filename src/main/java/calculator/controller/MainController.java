package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Set;

public class MainController {

    private static final String DEFAULT_SEPARATOR1 = ",";
    private static final String DEFAULT_SEPARATOR2 = ":";
    private static final String REGEX = "^//(.*)\\\\n";
    private final Calculator calculator;

    public MainController(final Calculator calculator) {
        this.calculator = calculator;
    }

    public static MainController create() {
        return new MainController(new Calculator());
    }

    public void run() {
        final String input = InputView.startInput();
        final Numbers numbers = createNumber(input);
        final int result = calculator.calculate(numbers);

        OutputView.printResultMessage(result);
    }

    private Numbers createNumber(String input) {
        final String[] stringNumber = splitString(input);
        return new Numbers(stringNumber);
    }

    private String[] splitString(String input) {
        final Set<String> defaultSeparator = Set.of(DEFAULT_SEPARATOR1, DEFAULT_SEPARATOR2);
        final Separator separator = new Separator(defaultSeparator);
        input = separator.addCustomSeparator(input, REGEX);
        return separator.separateString(input);
    }
}
