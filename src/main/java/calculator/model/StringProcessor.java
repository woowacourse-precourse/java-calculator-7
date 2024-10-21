package calculator.model;

import calculator.model.vo.Number;
import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private final Delimiter delimiter;

    public StringProcessor() {
        this.delimiter = new Delimiter();
    }

    public List<Number> interpret(String expression) {
        delimiter.chooseFrom(expression);
        String removed = delimiter.removeAffix(expression);
        return convertToNumbers(removed);
    }

    private List<Number> convertToNumbers(String expression) {
        return Arrays.stream(expression.split(delimiter.getRegex()))
                .map(Number::of)
                .toList();
    }
}