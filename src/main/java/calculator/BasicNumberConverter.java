package calculator;

import java.util.Collections;
import java.util.List;

public class BasicNumberConverter {

    private static final List<Character> DELIMITERS = List.of(',', ':');
    private final InputDivider divider;

    public BasicNumberConverter(String inputString) {
        this.divider = new InputDivider(inputString, DELIMITERS);
    }

    public List<Long> convert() {
        List<String> divided = divider.divide();
        return Collections.emptyList();
    }
}
