package calculator;

public class DelimiterManager {

    // 기본 구분자 및 커스텀 구분자 추출
    public String determineDelimiters(String input) {
        String standardDelimiters = ",|:";  // 기본 구분자

        if (input.startsWith("//")) {
            return extractCustomDelimiter(input, standardDelimiters);
        }

        return standardDelimiters;  // 커스텀 구분자가 없을 경우 기본 구분자 반환
    }

    // 커스텀 구분자 추출 로직을 별도로 분리
    private String extractCustomDelimiter(String input, String standardDelimiters) {
        int delimiterEndIndex = input.indexOf("\n");
        String customDelimiter = input.substring(2, delimiterEndIndex);
        return standardDelimiters + "|" + customDelimiter;  // 기본 구분자와 커스텀 구분자 함께 반환
    }

    // 숫자 부분 추출
    public String extractNumberSection(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);  // 구분자 뒤의 숫자 부분만 반환
        }

        return input;  // 커스텀 구분자가 없으면 전체 문자열 반환
    }
}