package calculator.domain;

import static calculator.utils.Parse.createDelimiterPattern;
import static calculator.utils.Parse.splitInput;
import static calculator.utils.Validator.validateCustomDelimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {
    private final Set<String> delimiters = new HashSet<>(Arrays.asList(",", ":"));
    private final List<Double> numbers;

    public InputHandler(String input) {
        List<String> inputParts = splitInput(input);
        processCustomDelimiter(inputParts);
        this.numbers = parseStringToNumbers(inputParts.get(inputParts.size() - 1));
    }

    private void processCustomDelimiter(List<String> inputParts) {
        if (inputParts.size() != 2) {
            return;
        }
        String customDelimiter = inputParts.get(0);
        validateCustomDelimiter(customDelimiter);
        delimiters.add(customDelimiter);
    }

    private List<Double> parseStringToNumbers(String numberString) {
        String delimiterPattern = createDelimiterPattern(delimiters);

        return Arrays.stream(numberString.split(delimiterPattern))
            .map(this::convertToDouble)
            .toList();
    }

    private Double convertToDouble(String number) {
        try {
            return Double.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    public List<Double> getParsedNumbers() {
        return new ArrayList<>(numbers);
    }
}
