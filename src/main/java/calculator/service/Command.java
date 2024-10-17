package calculator.service;

import java.util.Optional;

public class Command {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";
    private static final String NO_VALUE = "";

    private final String customSeparator;
    private final String expression;

    public Command(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        this.customSeparator = parseCustomSeparator(input);
        this.expression = parseFormula(input);
    }

    private String parseFormula(String input) {
        return input.replaceAll(CUSTOM_SEPARATOR_REGEX, NO_VALUE);
    }

    private String parseCustomSeparator(String input) {
        Optional<String> customSeparator = new CustomSeparatorManager(input).extract();
        return customSeparator.orElse(NO_VALUE);
    }

    public boolean hasCustomSeparator() {
        return !customSeparator.equals(NO_VALUE);
    }

    public String getCustomSeparator() {
        return customSeparator;
    }

    public String getExpression() {
        return expression;
    }
}
