package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SplitNumbers {
    private static final String NORMAL_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final List<Integer> numbers;

    private SplitNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 구분자 사이에 숫자는 양수여야 합니다.");
        }
    }

    public static SplitNumbers of(List<Integer> numbers) {
        return new SplitNumbers(numbers);
    }

    public static SplitNumbers from(String inputValue) {
        String delimiter = getDelimiter(inputValue);
        String numberString = removeDelimiterDeclaration(inputValue);
        List<Integer> numbers = splitNumberString(numberString, delimiter);
        return of(numbers);
    }

    private static String getDelimiter(String inputValue) {
        int firstCustomDelimiterIndex = inputValue.indexOf(CUSTOM_DELIMITER_PREFIX);
        int secondCustomDelimiterIndex = inputValue.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (isNotCustomDelimiter(firstCustomDelimiterIndex)) {
            return NORMAL_DELIMITER;
        }

        if (firstCustomDelimiterIndex >= secondCustomDelimiterIndex) {
            throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }

        String customDelimiter = getCustomDelimiter(inputValue, firstCustomDelimiterIndex, secondCustomDelimiterIndex);
        return getFinalDelimiter(customDelimiter);
    }

    private static boolean isNotCustomDelimiter(int firstCustomDelimiterIndex) {
        return firstCustomDelimiterIndex == -1;
    }

    private static String getCustomDelimiter(String inputValue, int firstCustomDelimiter, int secondCustomDelimiter) {
        return Pattern.quote(inputValue.substring(firstCustomDelimiter + 2, secondCustomDelimiter));
    }

    private static String getFinalDelimiter(String customDelimiter) {
        return NORMAL_DELIMITER + "|" + customDelimiter;
    }

    private static String removeDelimiterDeclaration(String inputValue) {
        int newLineIndex = inputValue.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return newLineIndex != -1 ? inputValue.substring(newLineIndex + 2) : inputValue;
    }

    private static List<Integer> splitNumberString(String inputValue, String delimiter) {
        try {
            return Arrays.stream(inputValue.split(delimiter))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 구분자 사이에는 숫자만 입력되어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}