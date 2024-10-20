package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcModel {
    private final static String DEFAULT_DELIMITER_PREFIX = "[,:]";
    private final static String CUSTOM_DELIMITER_START_PREFIX = "//";
    private final static String DELIMITER_NOT_VALID = "잘못된 구분자 형식입니다.";
    private final static String NUMBER_NOT_POSITIVE = "음수는 입력 불가능합니다.";
    private final static String INPUT_NOT_VALID = "숫자 이외에는 입력할 수 없습니다.";

    public int calcResult(String inputString) {
        if (inputString == null || inputString.isBlank())
            return 0;

        if (inputString.startsWith(CUSTOM_DELIMITER_START_PREFIX))
            return sumWithCustomDelimiter(inputString);

        return sumNumbers(parseByDelimiter(inputString, DEFAULT_DELIMITER_PREFIX));
    }

    private int sumNumbers(int[] numArray) {
        return Arrays.stream(numArray).sum();
    }

    public int sumWithCustomDelimiter(String inputString) {
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(inputString);
        if (!matcher.matches())
            throw new IllegalArgumentException(DELIMITER_NOT_VALID);

        String customDelimiter = Pattern.quote(matcher.group(1));
        String numbers = matcher.group(2);
        return sumNumbers(parseByDelimiter(numbers, customDelimiter));
    }

    public int[] parseByDelimiter(String inputString, String delimiter) {
        return Arrays.stream(inputString.split(delimiter))
                .map(String::trim)
                .mapToInt(this::parseNum)
                .toArray();
    }

    public int parseNum(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 0)
                throw new IllegalArgumentException(NUMBER_NOT_POSITIVE);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_VALID);
        }

    }
}
