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

    private final Delimiters delimiters;
    private final String numberPart;

    private Extractor(String input) {
        this.delimiters = Delimiters.from(input);
        this.numberPart = extractNumberPart(input);
    }

    public static Extractor from(String input) {
        return new Extractor(input);
    }

    public String extractNumberPart(String userInput) {
        if (delimiters.isCustomDelimiter()) {
            return userInput.split(SPLIT_NUMBER_PART_REGEX)[1];
        }
        return userInput;
    }

    public Numbers extractNumbers() {
        List<Number> numbers = new ArrayList<>();
        if (numberPart.isEmpty()) {
            numbers.add(new Number());
            return Numbers.from(numbers);
        }
        Pattern pattern = Pattern.compile(String.format(NUMBER_PART_REGEX, delimiters.getDelimiters()));
        Matcher matcher = pattern.matcher(numberPart);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자와 구분자로만 이루어져야 합니다.");
        }
        String splitRegex = delimiters.getSplitRegex();
        String[] extractedNumbers = numberPart.split(splitRegex);
        Arrays.stream(extractedNumbers)
            .map(Integer::parseInt)
            .forEach(value -> numbers.add(new Number(value)));
        return Numbers.from(numbers);
    }

}
