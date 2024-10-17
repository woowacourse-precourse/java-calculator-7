package calculator.domain;

public class StringParser {

    private static final String CUSTOM_FIRST_DELIMITER = "//";
    private static final String CUSTOM_SECOND_DELIMITER = "\n";

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int calculateInput(String input) {
        String[] numbers = splitCustomInput(input);
        int result = 0;
        return result;
    }

    public static String[] splitCustomInput(String input) {
        // 커스텀 구분자를 사용하는 경우
        if (input.startsWith(CUSTOM_FIRST_DELIMITER)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_SECOND_DELIMITER);

            String customDelimiter = input.substring(2, delimiterEndIndex);
            String numbers = input.substring(delimiterEndIndex + 1);

            return numbers.split(customDelimiter + "|" + DEFAULT_DELIMITERS);
        } else {
            return input.split(DEFAULT_DELIMITERS);  // 기본 구분자를 사용하는 경우
        }
    }
}
