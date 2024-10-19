package calculator.service.separation;

import calculator.domain.Numbers;

public interface SeparationService {

    boolean hasCustomSeparator(String input);

    Numbers getNumbers(String input, String... separators);

    default String[] split(String input, String separatorOrRegex) {
        return input.split(separatorOrRegex);
    }
}
