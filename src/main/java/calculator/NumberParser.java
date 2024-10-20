package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberParser {
    public List<Integer> parse(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        String delimiters = "[,:]";
        String[] numbers = input.split(delimiters);
        return convertToIntegerList(numbers);
    }

    private List<Integer> convertToIntegerList(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
