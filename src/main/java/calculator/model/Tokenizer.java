package calculator.model;

import java.util.List;

public interface Tokenizer {
    List<Integer> toTokenizedList(String input);
}
