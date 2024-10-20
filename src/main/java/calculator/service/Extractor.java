package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Number;
import calculator.domain.Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public static final String NUMBER_PART_REGEX = "-?\\d+([%s]-?\\d+)*";
    public static final String SPLIT_NUMBER_PART_REGEX = "\\\\n";
    public static final int REPLACE_EMPTY_VALUE = 0;

    private final Delimiters delimiters;
    private final Numbers numbers;

    private Extractor(String input) {
        this.delimiters = Delimiters.from(input);
        this.numbers = extractNumbers(input);
    }

    public static Extractor from(String input) {
        return new Extractor(input);
    }

    private Numbers extractNumbers(String userInput) {
        if (userInput.isBlank()) {
            return Numbers.from(List.of(new Number(REPLACE_EMPTY_VALUE)));
        }
        if (delimiters.isCustomDelimiter()) {
            String numberPart = userInput.split(SPLIT_NUMBER_PART_REGEX)[1];
            return convertToNumbers(numberPart);
        }
        return convertToNumbers(userInput);
    }

    private Numbers convertToNumbers(String numberPart) {
        validateNumberPart(numberPart);
        String[] extractedNumbers = splitNumberPart(numberPart);
        List<Number> numbers = Arrays.stream(extractedNumbers)
            .map(Integer::parseInt)
            .map(Number::new)
            .toList();
        return Numbers.from(numbers);
    }

    private void validateNumberPart(String numberPart) {
        Pattern pattern = Pattern.compile(String.format(NUMBER_PART_REGEX, delimiters.getRegex()));
        Matcher matcher = pattern.matcher(numberPart);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자와 구분자로만 이루어져야 합니다.");
        }
    }

    private String[] splitNumberPart(String numberPart) {
        String splitRegex = delimiters.getSplitRegex();
        return numberPart.split(splitRegex);
    }

    public Numbers getNumbers() {
        return numbers;
    }

}
