package calculator.model;

import java.util.List;

public interface ParsingStrategy {
    List<Integer> parse(final String input);
}
