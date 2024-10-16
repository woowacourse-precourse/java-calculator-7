package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringIntegerConverter {
    public List<Integer> convert(List<String> input) {
        List<Integer> result = new ArrayList<Integer>();

        for (String s : input) {
            if (s.isEmpty()) {
                result.add(0);
            } else if (s.matches("[0-9]+")) {
                result.add(convertToPositiveInteger(s));
            } else {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }

    private int convertToPositiveInteger(String input) {
        int number = Integer.parseInt(input);

        if (number > 0) {
            return number;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
