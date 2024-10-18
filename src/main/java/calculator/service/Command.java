package calculator.service;

import calculator.util.Constants;
import java.util.Optional;

public class Command {

    private final Separator customSeparator;
    private final String expression;

    public Command(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        this.customSeparator = parseCustomSeparator(input);
        this.expression = parseExpression(input);
    }

    private Separator parseCustomSeparator(String input) {
        Optional<String> customSeparator = new CustomSeparatorManager(input).extract();
        return customSeparator.map(Separator::create)
                .orElse(null);
    }

    private String parseExpression(String input) {
        String expression = input.replaceAll(Constants.CUSTOM_SEPARATOR_REGEX, Constants.NO_VALUE);
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("식이 존재하지 않습니다.");
        }
        return expression;
    }

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }

    public Separator getCustomSeparator() {
        return customSeparator;
    }

    public String getExpression() {
        return expression;
    }
}
