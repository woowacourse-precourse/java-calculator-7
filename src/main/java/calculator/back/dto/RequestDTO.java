package calculator.back.dto;

import java.util.List;

public record RequestDTO(List<Character> delimiters, String inputWithDelimiters) {
}
