package calculator;

public class DelimiterParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    public String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return extractCustomDelimiter(input);
        }
        return DEFAULT_DELIMITER;
    }


    private String extractCustomDelimiter(String input) {

        // 커스텀 구분자 처리
        int delimiterEnd = input.indexOf("\\n");
        if (delimiterEnd != -1) {
            // 커스텀 구분자 추출
            return input.substring(2, delimiterEnd);
        } else {
            // '\n'이 없을 경우 예외 처리
            throw new IllegalArgumentException("잘못된 형식의 입력입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }
    }

    public String extractNumbers(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                return input.substring(delimiterEnd + 2);
            }
        }
        return input;
    }
}
