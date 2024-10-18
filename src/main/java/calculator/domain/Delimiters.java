package calculator.domain;

import calculator.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiters {

    private final List<String> elements;

    public Delimiters() {
        this.elements = new ArrayList<>();
        elements.add(",");
        elements.add(":");
    }

    public List<String> getElements() {
        return new ArrayList<>(elements);
    }

    public void addDelimiter(String delimiter) {
        validateDelimiter(delimiter);
        elements.add(delimiter);
    }

    private void validateDelimiter(String delimiter) {
        String NUMBER_REGEXP = "^\\d*$";
        if (Pattern.matches(NUMBER_REGEXP, delimiter)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NUMBER_WITH_SEPARATOR;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
