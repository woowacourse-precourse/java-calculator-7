package calculator;

public class DelimiterManager {
    private String delimiterRegex = ",|:";

    public String extractDelimiter(String command) {
        if (!command.isEmpty()) {
            return delimiterRegex + "|" + command.substring(2); // 커스텀 구분자 추가
        }
        return delimiterRegex; // 기본 구분자 반환
    }
}
