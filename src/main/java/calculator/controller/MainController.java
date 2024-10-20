package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    private static final String SEPARATOR = ",|:";
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
        final String[] stringNumber = splitString(input);

        final Numbers numbers = new Numbers(stringNumber);
        final int result = calculator.calculate(numbers);

        OutputView.printResultMessage(result);
    }

    private String[] splitString(String input) {
        String addedSeparator = "";
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        if (matcher.find()) {
            addedSeparator = Pattern.quote(matcher.group(1));
            input = input.substring(matcher.end());
        }
        return input.trim().split(SEPARATOR + "|" + addedSeparator);
    }
}
