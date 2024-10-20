package calculator;

import java.util.Arrays;

public class DelimiterAndNumber {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final String delimiter;
    private final String numbers;

    public DelimiterAndNumber(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public static DelimiterAndNumber parse(String str) {
        if (!str.startsWith(CUSTOM_DELIMITER_PREFIX) && !str.contains(CUSTOM_DELIMITER_SUFFIX)) {
            return new DelimiterAndNumber(DEFAULT_DELIMITER, str);
        }
        if (str.startsWith(CUSTOM_DELIMITER_PREFIX) && str.contains(CUSTOM_DELIMITER_SUFFIX)) {
            int mark = str.indexOf(CUSTOM_DELIMITER_SUFFIX);
            String delimiter = str.substring(CUSTOM_DELIMITER_PREFIX.length(), mark);
            String numbers = str.substring(mark + CUSTOM_DELIMITER_SUFFIX.length());
            return new DelimiterAndNumber(delimiter, numbers);
        }
        throw new IllegalArgumentException("잘못된 구분자 사용법입니다.");
    }

    public int sum() {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(token -> {
                    try {
                        int num = Integer.parseInt(token);
                        if (num < 0) {
                            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
                        }
                        return num;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("추출할 수 없는 숫자가 존재합니다.");
                    }
                })
                .sum();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getNumbers() {
        return numbers;
    }
}
