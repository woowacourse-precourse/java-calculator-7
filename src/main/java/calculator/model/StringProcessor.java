package calculator.model;

import calculator.model.vo.Number;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringProcessor {
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private List<String> delimiters;

    public StringProcessor() {
        this.delimiters = new ArrayList<>();
    }

    public List<Number> interpret(String expression) {
        delimiters = List.of(COLON, COMMA);
        return Arrays.stream(expression.split(concatDelimiters()))
                .map(Number::of)
                .toList();
    }

    private String concatDelimiters() {
        return String.join("|", delimiters);
    }
}
