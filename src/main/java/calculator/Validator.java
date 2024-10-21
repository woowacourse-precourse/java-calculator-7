package calculator;

import static calculator.Constants.CUSTOM_END;
import static calculator.Constants.CUSTOM_START;

public class Validator {
    static String findCustomDelimiter(String str) {
        if (str.startsWith(CUSTOM_START)) {
            if (!str.contains(CUSTOM_END)) {
                throw new IllegalArgumentException("올바르지 못한 입력", new Throwable("커스텀 구분자 페어가 맞지 않음"));
            }
            int last = str.indexOf(CUSTOM_END);
            return str.substring(CUSTOM_START.length(), last);
        }
        return "";
    }
}
