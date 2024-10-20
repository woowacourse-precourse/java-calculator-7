package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Extractor {

    private static final String HEADER = "//";
    private static final String FOOTER = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int NUMBER_BEGIN_INDEX = 5;

    public boolean hasCustomDelimiter(String numsWithCustomDelimiter) {
        return numsWithCustomDelimiter.startsWith(HEADER);
    }

    public String extractCustomDelimiter(String numsWithDelimiter) {
        return numsWithDelimiter.substring(2, 3);
    }

    public int[] extractNumbersWithDefaultDelimiter(String delimitedNumsWithDefault) {
        String[] splitNumbers = delimitedNumsWithDefault.split(DEFAULT_DELIMITER);
        return Arrays.stream(splitNumbers).mapToInt(this::parseNumber).toArray();
    }

    public int[] extractNumbersWithCustomDelimiter(String delimitedNumsWithCustom, String customDelimiter) {
        String regex = Pattern.quote(customDelimiter);
        String[] splitNumbers = getNumbersWithoutPrefix(delimitedNumsWithCustom).split(regex);
        return Arrays.stream(splitNumbers).mapToInt(this::parseNumber).toArray();
    }

    private String getNumbersWithoutPrefix(String delimitedNumsWithCustom) {
        return delimitedNumsWithCustom.substring(NUMBER_BEGIN_INDEX);
    }

    private int parseNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }
}