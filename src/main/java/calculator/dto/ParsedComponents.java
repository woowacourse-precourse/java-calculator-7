package calculator.dto;

import java.util.List;

public record ParsedComponents(List<Character> delimiters, String numbersPart) {
}