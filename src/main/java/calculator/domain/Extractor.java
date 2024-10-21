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
    }

    public String extractCustomDelimiter(String numsWithDelimiter) {
        String footer = numsWithDelimiter.substring(3, 5);
        if (numsWithDelimiter.startsWith(HEADER) && footer.equals(FOOTER)) {
            return numsWithDelimiter.substring(2, 3);
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }

    public int[] extractNumbersWithDefaultDelimiter(String delimitedNumsWithDefault) {
        if (!delimitedNumsWithDefault.matches("^[0-9]+((.)[0-9]+)*$")) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
        String[] splitNumbers = delimitedNumsWithDefault.split(DEFAULT_DELIMITER);
        return Arrays.stream(splitNumbers).mapToInt(this::parseNumber).toArray();
    }

    public int[] extractNumbersWithCustomDelimiter(String delimitedNumsWithCustom, String customDelimiter) {
        String regex = Pattern.quote(customDelimiter);
        String[] splitNumbers = getNumbersWithoutPrefix(delimitedNumsWithCustom).split(regex);
        return Arrays.stream(splitNumbers).mapToInt(this::parseNumber).toArray();
    }

    private String getNumbersWithoutPrefix(String delimitedNumsWithCustom) {
        String nums = delimitedNumsWithCustom.substring(NUMBER_BEGIN_INDEX);
        if (nums.matches("^[0-9]+((.)[0-9]+)*$")) {
            return nums;
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }

    private int parseNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }
}