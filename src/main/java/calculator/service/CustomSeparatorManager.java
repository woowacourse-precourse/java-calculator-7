package calculator.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorManager {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*?)\\\\n");

    private final String input;

    public CustomSeparatorManager(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        this.input = input;
    }

    public Optional<String> extract() {
        if (hasCustomSeparator()) {
            Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
            if (matcher.find()) {
                validateMultipleCustomSeparators();
                String customSeparator = matcher.group(1);
                validateCustomSeparator(customSeparator);
                return Optional.of(customSeparator);
            }
        }
        return Optional.empty();
    }

    private boolean hasCustomSeparator() {
        return CUSTOM_SEPARATOR_PATTERN.matcher(input)
                .find();
    }

    public void validateMultipleCustomSeparators() {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find() && matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자는 하나만 추가할 수 있습니다.");
        }
    }

    private void validateCustomSeparator(String customSeparator) {
        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.");
        }
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        if (!SeparatorType.isPermitted(customSeparator)) {
            throw new IllegalArgumentException("허용되지 않는 커스텀 구분자입니다.");
        }
    }
}
