package calculator.domain;


import java.util.List;

public record UserInput(String input, boolean hasCustomDelimiter, List<String> delimiters) {
}
