package calculator.domain;

import java.util.List;

public class Data {
    private static final String EMPTY_STRING = "";
    private final String input;
    private final Separator separator;
    private final Number number;

    public Data(String input) {
        this.input = input;
        separator = new Separator(input);
        number = new Number();
    }

    public int calculateAddition() {
        int sum = 0;
        for (int number : number.getNumbers()) {
            sum += number;
        }
        return sum;
    }

    public void handleInput() {
        if (hasEmptyString()) {
            number.handleEmptyData();
            return;
        }
        List<String> extractedStrings = separator.removeSeparator();
        SeparatorValidator.validateSeparator(extractedStrings);
        number.convertNumbers(extractedStrings);
        NumberValidator.validateNumber(number.getNumbers());
    }

    private boolean hasEmptyString() {
        return input.equals(EMPTY_STRING);
    }
}
