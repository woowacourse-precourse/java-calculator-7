package calculator.util;

public class StringUtil {

    public static String extractCustomDelimiter(String str) {
        if (str.startsWith("//")) {
            if (str.indexOf("\\n") != 3) {
                throw new IllegalArgumentException("커스텀 구분자 양식 오류");
            }
            return String.valueOf(str.charAt(2));
        }
        return null;
    }

    public static String extractString(String str) {
        if (str.startsWith("//")) {
            return str.substring(5);
        }
        return str;
    }
}
