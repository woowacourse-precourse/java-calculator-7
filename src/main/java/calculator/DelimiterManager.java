package calculator;

public class DelimiterManager {

    // 기본 구분자 + 커스텀 구분자 추출
    public String getDelimiters(String input) {
        String standardDelimiters = ",|:";  // 기본 구분자

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 추출
            return standardDelimiters + "|" + customDelimiter;  // 기본 구분자와 커스텀 구분자 함께 반환
        }

        return standardDelimiters;  // 커스텀 구분자가 없으면 기본 구분자만 반환
    }

    // 숫자 부분 추출
    public String getNumberSection(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);  // 구분자 뒤의 숫자 부분만 반환
        }

        return input;  // 커스텀 구분자가 없으면 전체 문자열 반환
    }
}