package calculator.model;

import java.util.List;
import java.util.SimpleTimeZone;

public class RegDelimiter {
    public boolean includesCustomDelimiter(String value) {
        if (value.length() >= 2) {
            if (value.charAt(0) == '/' && value.charAt(1) == '/') {
                return true;
            }
        }
        return false;
    }

    public String findCustomDelimiter(String value) {
        String customDeli = "";
        int valueLength = value.length();

        for (int i=2; i<valueLength; i++) {
            customDeli += value.substring(i, i+1);
        }
        validateCustomDeli(customDeli);
        return customDeli;
    }

    public void validateCustomDeli(String customDeli) {
        String[] reservedWords = new String[]{"//", "\\n", "-", ",", ":"};
        String numberRegex = ".*[0-9].*";

        for (String resWord : reservedWords) {
            if (customDeli.contains(resWord)
            || customDeli.matches(numberRegex)) {
                throw new IllegalArgumentException("잘못된 구분자입니다. // \\n - , : 또는 숫자를 제외한 문자를 입력해주세요.");
            }
        }
    }
}
