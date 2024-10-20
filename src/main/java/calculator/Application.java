package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String delimiterPattern = buildDelimiterPattern(COMMA_DELIMITER, COLON_DELIMITER);
        // 사용자 정의 구분자 처리 추가 예정
    }

    private static String buildDelimiterPattern(String... delimiters) {
        StringBuilder delimiterBuilder = new StringBuilder();
        for (String delimiter : delimiters) {
            delimiterBuilder.append(Pattern.quote(delimiter)).append("|");
        }
        delimiterBuilder.setLength(delimiterBuilder.length() - 1);
        return delimiterBuilder.toString();
    }
}
