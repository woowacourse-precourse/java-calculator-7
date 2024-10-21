package calculator.dto;

import java.util.List;

public record ExtractionResult(List<String> delimiters, String remainingInput) {
    public static ExtractionResult of(List<String> delimiters, String remainingInput) {
        return new ExtractionResult(List.copyOf(delimiters), remainingInput);
    }
}
