package calculator.provider;

import java.util.List;

public class BasicStringTokenizer {

    private static final List<Character> DELIMITERS = List.of(',', ':');
    private final InputDivider inputDivider;

    public BasicStringTokenizer(String inputString) {
        this.inputDivider = new InputDivider(inputString, DELIMITERS);
    }

    public List<String> tokenize() {
        return inputDivider.divide();
    }

}
