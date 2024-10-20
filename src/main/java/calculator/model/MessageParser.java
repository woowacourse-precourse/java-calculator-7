package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class MessageParser {
    private final Delimiter delimiter;
    private final String message;

    public MessageParser(String message) {
        this.delimiter = new Delimiter(message);
        int startIndex = delimiter.getNumbersStartIndex(message);
        this.message = message.substring(startIndex);
    }

    public List<Integer> parseNumbers() {
        List<Integer> numbers = new ArrayList<>();

        if (message.isEmpty()) {
            return numbers;
        }

        String[] splitNumbers = message.split(delimiter.getRegexString());

        for (String number : splitNumbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("Invalid number: " + num);
            }

            numbers.add(num);
        }

        return numbers;
    }
}