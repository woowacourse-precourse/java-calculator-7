package calculator.domain;

public class CustomDelimiter{

    // "//"문자 다음 인덱스 부터 "\n" 전까지의 문자를 반환
    public static String getCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        return input.substring(startIndex, endIndex);
    }

    // 커스텀 문자열 내용을 제거한 문자열을 반환
    public static String removeCustomDelimiter(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }
}
