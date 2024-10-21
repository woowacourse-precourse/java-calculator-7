package calculator.controller;

public class CalculatorController {

    private static final String SETUP_SYMBOL_COMMA = ",";
    private static final String SETUP_SYMBOL_COLON = ":";

    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.*?)\\n");
    private final InputView inputView = new InputView();
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
    }
}
