package calculator.model;

import calculator.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    private Delimiters delimiters;
    private String input;

    public Parser(String input) {
        this.input = input;
        this.delimiters = new Delimiters();
    }

    public List<Integer> parse() {
        if (delimiters.hasCustomDelimiter(input)) {
            delimiters.addCustomDelimiter(input);
            input = input.substring(5);
            return getIntegers();
        }
        return getIntegers();
    }

    private List<Integer> getIntegers() {
        List<String> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiters.toConcatenatedString());
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }
        return result.stream().map(Integer::parseInt)
                .map(this::getPositiveNumber).toList();
    }

    private Integer getPositiveNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_OUT_OF_RANGE.getMessage());
        }
        return number;
    }
}
