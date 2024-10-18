package calculator;

public class StringUtil {
    // 메타 문자를 이스케이프 처리하는 메서드
    public static String escapeMetaCharacters(String delimiter) {
        return delimiter.replaceAll("([{}()\\[\\].*+?|^$\\\\])", "\\\\$1");
    }
}
