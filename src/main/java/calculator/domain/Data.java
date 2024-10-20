package calculator.domain;

import java.util.List;

public class Data {
    private static final String EMPTY_STRING = "";
    private final String input;
    private final Separator separator;
    private final List<Integer> numbersForSum;

    public Data(String input) {
        this.input = input;
        separator = new Separator(input);
        numbersForSum = handleInput();
    }

    public int calculateAddition() {
        int sum = 0;
        for (int number : numbersForSum) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> handleInput() {
        if (hasEmptyString()) {
            numbersForSum.add(0);
            return numbersForSum;
        }
        String[] extractedStrings = separator.removeSeparator();
        SeparatorValidator.validate(extractedStrings);
        return NumberValidator.convertNumbers(extractedStrings);
    }

    private boolean hasEmptyString() {
        return input.equals(EMPTY_STRING);
    }
}
