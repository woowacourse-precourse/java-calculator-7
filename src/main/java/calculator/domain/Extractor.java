package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Extractor {

    private static final String HEADER = "//";
    private static final String FOOTER = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int NUMBER_BEGIN_INDEX = 5;

    public boolean isDefaultDelimiterUsed(String numsWithCustomDelimiter) {
        return numsWithCustomDelimiter.matches("^[0-9]+([,:][0-9]+)*$");
//        String footer = numsWithCustomDelimiter.substring(3, 5);
//        return numsWithCustomDelimiter.startsWith(HEADER) && footer.equals(FOOTER);
    }

    public String extractCustomDelimiter(String numsWithDelimiter) {
        String footer = numsWithDelimiter.substring(3, 5);
        if (numsWithDelimiter.startsWith(HEADER) && footer.equals(FOOTER)) {
            return numsWithDelimiter.substring(2, 3);
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
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