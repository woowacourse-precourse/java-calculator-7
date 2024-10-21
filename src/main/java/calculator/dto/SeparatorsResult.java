package calculator.dto;

import calculator.domain.Separators;

public record SeparatorsResult(
        Separators separators,
        String input
) {
}
