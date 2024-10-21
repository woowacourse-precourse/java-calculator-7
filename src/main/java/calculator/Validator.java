package calculator;

import static calculator.Constants.CUSTOM_START;

public class Validator {
    static String findCustomDelimiter(String str) {
        if (str.startsWith(CUSTOM_START)) {
            if (!str.contains("\\n")) {
                throw new IllegalArgumentException("올바르지 못한 입력", new Throwable("커스텀 구분자 페어가 맞지 않음"));
            }
            int last = str.indexOf("\\n");
            return str.substring(CUSTOM_START.length(), last);
        } else if (!Character.isDigit(str.charAt(0))) {
            throw new IllegalArgumentException("올바르지 못한 입력", new Throwable("양수만 연산이 가능합니다."));
        }
        return "";
    }
}
