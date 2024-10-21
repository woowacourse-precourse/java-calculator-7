package calculator;

import java.util.ArrayList;

public class Parser {
    private int result = 0;
    private ArrayList<Integer> numbers;

    public String parse(String input, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiters();
        numbers = new ArrayList<>();

        for (String number : input.split(delimiters)) {
            numbers.add(Integer.parseInt(number));
        }

        for (int number : numbers) {
            result += number;
        }

        return String.valueOf(result);
    }

    public int getResult() {
        return result;
    }
}
