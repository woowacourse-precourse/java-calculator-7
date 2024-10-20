package calculator;

// 입력 문자열에서 구문자를 추출하는 클래스
public class ExtractDelimiter {
    // 구분자 추출
    static String extract_delimiter(String input) {
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            int delimiterEnd = input.indexOf("\n");
            return input.substring(2, delimiterEnd);
        }
        // 기본 구분자 ',' 또는 ':'
        return "[,:]";
    }
}
