package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final Delimiter delimiter;

    public Parser() {
        delimiter = new Delimiter();
    }

    public List<Integer> parse(String input) throws IllegalArgumentException {
        var digits = new ArrayList<Integer>();
        delimiter.calculateDelimiters(input);

        int digit = 0;
        for (int i = delimiter.getSkipSize(); i < input.length(); i++) {
            char current = input.charAt(i);
            if ('0' <= current && current <= '9') {
                digit *= 10;
                digit += current - '0';
            } else if (delimiter.contains(current)) {
                digits.add(digit);
                digit = 0;
            } else {
                throw new IllegalArgumentException();
            }

            if (i + 1 == input.length()) {
                digits.add(digit);
            }
        }
        return digits;

    }
}
