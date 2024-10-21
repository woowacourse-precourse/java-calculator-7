package calculator.service.separation;

import calculator.service.dto.NumbersDto;

public interface SeparationService {

    String[] EMPTY_ARRAY = {"0"};

    boolean hasCustomSeparator(String input);

    NumbersDto getNumbers(String input, String... separators);

    default String[] split(String input, String separatorOrRegex) {
        if (input.isBlank()) {
            return EMPTY_ARRAY;
        }
        return input.split(separatorOrRegex);
    }
}
