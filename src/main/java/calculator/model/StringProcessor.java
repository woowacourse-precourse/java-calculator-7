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
        delimiter.choose(expression);
        String cleanedExpression = delimiter.removeAffix(expression);
        return splitAndConvert(cleanedExpression);
    }

    private List<Number> splitAndConvert(String expression) {
        return Arrays.stream(expression.split(delimiter.concatDelimiters()))
                .map(Number::of)
                .toList();
    }
}