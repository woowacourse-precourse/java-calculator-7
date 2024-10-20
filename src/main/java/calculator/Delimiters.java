package calculator;

import java.util.regex.Pattern;

public class Delimiters {
    // 쉼표, 콜론으로 숫자를 분리하는 메서드
    public String[] defaultDelimiter(String input) {
        return input.split("[,:]");
    }

    // 커스텀 구분자로 숫자를 분리하는 메서드
    public String[] CustomDelimiter(String input) {
        int idx = input.indexOf("\\n");
        String customDelimiter = input.substring(2, idx); // 구분자 추출
        String str = input.substring(idx + 2); // \n 이후 부분 추출
        String escapedDelimiter = Pattern.quote(customDelimiter);
        return str.split(escapedDelimiter); // 이스케이프된 구분자로 분리
    }
}
