package calculator.collection;

import calculator.exception.InvalidInputException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientInputNumber {
    private final String DEFAULT_DELIMITERS = ",:";
    private final String CUSTOM_DELIMITER_FORMAT_REGEX = "(//.+\\n)";
    private final String INPUT_REGEX = CUSTOM_DELIMITER_FORMAT_REGEX + "?.+";

    private final List<Integer> inputNumbers;

    public ClientInputNumber(String input) {
        validateInput(input.trim());
        inputNumbers = splitInput(input.trim());
    }

    private void validateInput(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new InvalidInputException();
        }
    }

    private List<Integer> splitInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_FORMAT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (input.matches(CUSTOM_DELIMITER_FORMAT_REGEX)) {

        }
    }

    public int getSum() {
        return inputNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
