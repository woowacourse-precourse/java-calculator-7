package calculator.controller;

import calculator.domain.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    private static final String SEPARATOR = ",|:";
    private static final String REGEX = "^//(.*)\\\\n";

    private MainController() {
    }

    public static MainController create() {
        return new MainController();
    }

    public void run() {
        final String input = InputView.startInput();
        final String[] stringNumber = splitString(input);

        Expression expression = new Expression(stringNumber);

        OutputView.printResultMessage(expression.getResult());
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
