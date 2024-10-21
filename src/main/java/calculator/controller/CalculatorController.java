package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.DelimiterManager;
import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorController {

    private static final String SETUP_SYMBOL_COMMA = ",";
    private static final String SETUP_SYMBOL_COLON = ":";

    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.*?)\\n");
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final DelimiterManager delimiterManager;

    public CalculatorController() {
        delimiterManager = new DelimiterManager(List.of(
                new Delimiter(SETUP_SYMBOL_COMMA)
                ,new Delimiter(SETUP_SYMBOL_COLON)
        ));
    }

    public void startCalculator(){
        String inputString = inputView.createString();
        DelimiterManager delimiterManager = extractCustomDelimiters(inputString);
    }

    private DelimiterManager extractCustomDelimiters(String input) {
        input = input.replace("\\n", "\n");
        Matcher matcher = DELIMITER_PATTERN.matcher(input);

        while (matcher.find()) {
            String delimiterBlock = matcher.group(1);
            delimiterManager.addDelimiter(delimiterBlock);
        }

        return delimiterManager;
    }

    private Numbers createNumbers(String inputString, DelimiterManager delimiterManager) {
        String numberPart = removeDelimiterDefinition(inputString);

        String delimiterPattern = delimiterManager.getDelimiters().stream()
                .map(Delimiter::getSymbol)
                .reduce((a, b) -> a + "|" + b)
                .orElse(",");

        return new Numbers(Arrays.stream(numberPart.split(delimiterPattern))
                .map(String::trim)
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    private String removeDelimiterDefinition(String inputString) {
        inputString = inputString.replace("\\n", "\n");
        return inputString.replaceAll("//.*?\\n", "");
    }
}
