package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Number;
import calculator.domain.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public static final String NUMBER_PART_REGEX = "-?\\d+([%s]-?\\d+)*";
    public static final String SPLIT_NUMBER_PART_REGEX = "\\\\n";
    public static final String REPLACE_EMPTY_VALUE = "0";

    private final Delimiters delimiters;
    private final String numberPart;

    private Extractor(String input) {
        this.delimiters = Delimiters.from(input);
        this.numberPart = extractNumberPart(input);
    }

    public static Extractor from(String input) {
        return new Extractor(input);
    }

    private String extractNumberPart(String userInput) {
        if (userInput.isBlank()) {
            return REPLACE_EMPTY_VALUE;
        }
        if (delimiters.isCustomDelimiter()) {
            return userInput.split(SPLIT_NUMBER_PART_REGEX)[1];
        }
        return userInput;
    }

    public Numbers extractNumbers() {
        validateNumberPart();
        List<Number> numbers = convertNumbers();
        return Numbers.from(numbers);
    }

    private void validateNumberPart() {
        Pattern pattern = Pattern.compile(String.format(NUMBER_PART_REGEX, delimiters.getRegex()));
        Matcher matcher = pattern.matcher(numberPart);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자와 구분자로만 이루어져야 합니다.");
        }
    }

    private List<Number> convertNumbers() {
        List<Number> numbers = new ArrayList<>();
        String[] extractedNumbers = splitNumberPart();
        Arrays.stream(extractedNumbers)
            .map(Integer::parseInt)
            .forEach(value -> numbers.add(new Number(value)));
        return numbers;
    }

    private String[] splitNumberPart() {
        String splitRegex = delimiters.getSplitRegex();
        return numberPart.split(splitRegex);
    }

}
