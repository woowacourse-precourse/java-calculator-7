package calculator;

public class StringPartManager {

    static void validateString(String str, String separators) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isSeparator(c, separators) && !Character.isDigit(c)) {
                throw new IllegalArgumentException("커스텀 구분자 지정을 제외한 문자열은 양수와 구분자로 이루어져야 합니다");
            }
        }
    }

    static boolean isSeparator(char c, String separators) {
        for (int i = 0; i < separators.length(); i++) {
            if (c == separators.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    static String initString(String input, boolean hasCustomSeparator) {
        if (!hasCustomSeparator) {
            return input;
        }
        int strStartIdx = input.indexOf("\\n") + 2;
        return input.substring(strStartIdx);
    }
}
