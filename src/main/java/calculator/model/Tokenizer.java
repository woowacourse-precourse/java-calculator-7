package calculator.model;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize(String input);
}
