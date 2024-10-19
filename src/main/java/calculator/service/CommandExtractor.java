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
            throw new IllegalArgumentException("입력값이 찾을 수 없어요. 입력값을 확인해주세요.");
        }
    }

    private Separator extractCustomSeparator(String input) {
        Matcher matcher = customSeparatorPattern.matcher(input);
        if (!matcher.find()) {
            return null;
        }

        String customSeparator = matcher.group(1);
        validateMultipleCustomSeparator(matcher);
        return Separator.create(customSeparator);
    }

    private void validateMultipleCustomSeparator(Matcher matcher) {
        if (matcher.find()) {
            throw new IllegalArgumentException("한 번에 하나의 커스텀 구분자만 추가할 수 있어요.");
        }
    }

    private String extractExpression(String input) {
        String expression = removeCustomSeparator(input);
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("계산할 식을 찾을 수 없어요. 입력값을 확인해주세요.");
        }
        return expression;
    }

    private String removeCustomSeparator(String input) {
        return input.replaceAll(Constants.CUSTOM_SEPARATOR_REGEX, Constants.NO_VALUE);
    }
}
