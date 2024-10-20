package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberConverter {
    private final List<String> numbers;

    public StringToNumberConverter(List<String> input) {
        validateNoLeadingZero(input);
        numbers = input;
    }

    public List<Integer> convert() {
        List<Integer> result = new ArrayList<>();
        for (String s : numbers) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                result.add(0);
            }
        }
        return result;
    }

    private void validateNoLeadingZero(List<String> input) {
        for (String s : input) {
            if (s != null && s.startsWith("0")) {
                throw new IllegalArgumentException();
            }
        }
    }
}