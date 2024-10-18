package calculator;

public class Parser {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final int CUSTOM_DELIMITER_LENGTH= 2;

    // 구분자를 기준으로 문자열 파싱하기
    public String[] parse(String input) {

        // 빈 문자열 또는 null 값이 들어올 경우 0을 반환하기
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        /*
         * 구분자를 기준으로 문자열 파싱하기 3가지 세부 기능 구현
         *
         * 기본 구분자(쉼표,클론)를 기준으로 숫자 분리하기
         * 커스텀 구분자 지정하기
         * 커스텀 구분자를 기준으로 숫자 분리하기
         */
        String delimiter;
        if (isCustomDelimiter(input)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END);
            delimiter = input.substring(CUSTOM_DELIMITER_LENGTH, delimiterIndex);
            input = input.substring(delimiterIndex + CUSTOM_DELIMITER_LENGTH);
        } else {
            delimiter = DEFAULT_DELIMITERS;
        }

        return input.split(delimiter);
    }

    // 커스텀 구분자 체크하기
    public boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START);
    }
}
