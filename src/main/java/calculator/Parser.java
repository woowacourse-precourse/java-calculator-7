package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final String delimiter;
    private String input;
    private final String delimiterRegex;

    public Parser(String input, String delimiter, String delimiterRegex) {
        this.input = input;
        this.delimiter = delimiter;
        this.delimiterRegex = delimiterRegex;
    }

    public List<Integer> parse() {
        if (input != null && input.startsWith("//")) {
            input = input.substring(4 + delimiter.length());
        }
        List<Integer> parsedNumbers = new ArrayList<Integer>();

        String[] numbers = input.split(delimiterRegex);
        for (String number : numbers) {
            String numberToParse = number.isEmpty() ? "0" : number;
            parsedNumbers.add(Integer.parseInt(numberToParse));
        }
        return parsedNumbers;
    }
}
