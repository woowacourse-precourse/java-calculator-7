package calculator.parser;

import calculator.delimiter.Delimiter;
import java.util.ArrayList;

public class Parser {
    private static ArrayList<Integer> parseNumbers(String input, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiters();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String number : input.split(delimiters)) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static int sumNumbers(ArrayList<Integer> numbers, int result) {
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    public String parse(String input, Delimiter delimiter) {

        int result = 0;
        ArrayList<Integer> numbers = parseNumbers(input, delimiter);
        result = sumNumbers(numbers, result);
        return String.valueOf(result);
    }
}
