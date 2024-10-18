package calculator.service;

import calculator.util.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExtractor {

    private final Pattern customSeparatorPattern;

    private CommandExtractor(Pattern customSeparatorPattern) {
        this.customSeparatorPattern = customSeparatorPattern;
    }

    public static CommandExtractor init() {
        return new CommandExtractor(Pattern.compile(Constants.CUSTOM_SEPARATOR_REGEX));
    }

    public Command extract(String input) {
        validateInput(input);
        Separator customSeparator = extractCustomSeparator(input);
        String expression = extractExpression(input);
        return new Command(customSeparator, expression);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    private Separator extractCustomSeparator(String input) {
        Matcher matcher = customSeparatorPattern.matcher(input);
        if (!matcher.find()) {
            return null;
        }

        String customSeparator = matcher.group(1);
        if (matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자는 하나만 추가할 수 있습니다.");
        }
        return Separator.create(customSeparator);
    }

    private String extractExpression(String input) {
        String expression = removeCustomSeparator(input);
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("식이 존재하지 않습니다.");
        }
        return expression;
    }

    private String removeCustomSeparator(String input) {
        return input.replaceAll(Constants.CUSTOM_SEPARATOR_REGEX, Constants.NO_VALUE);
    }
}
