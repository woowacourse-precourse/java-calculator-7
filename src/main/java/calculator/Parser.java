package calculator;

import java.util.ArrayList;

public class Parser {
    private int result = 0;

    public String parse(String input, Delimiter delimiter) {
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
