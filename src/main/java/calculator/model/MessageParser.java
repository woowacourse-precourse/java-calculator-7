package calculator.model;

import calculator.errors.InputError;
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
            numbers.add(parseNumber(number));
        }

        return numbers;
    }

    private int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException(InputError.NEGATIVE.getMessage() + num); // 음수일 때
            }
            return num;
        } catch (NumberFormatException e) {
            try {
                Long.parseLong(number);
                throw new IllegalArgumentException(
                        InputError.OUT_OF_RANGE.getMessage() + number); // int 범위를 벗어났을 때
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException(
                        InputError.INVALID_FORMAT.getMessage() + number); // 숫자 형식이 잘못되었을 때
            }
        }
    }
}