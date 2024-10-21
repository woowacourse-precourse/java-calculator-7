package calculator;

import java.util.ArrayList;

public class Parser {
    public String parse(String input, Delimiter delimiter) {
        int result = 0;
        String delimiters = delimiter.getDelimiters();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String number : input.split(delimiters)) {
            numbers.add(Integer.parseInt(number));
        }

        for (int number : numbers) {
            result += number;
        }

        return String.valueOf(result);
    }
}
