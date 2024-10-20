package calculator.util;

import calculator.domain.Form;

import java.util.ArrayList;
import java.util.List;

public class FormParser {
    public static Form makeForm(String str) {
        // 빈 문자열
        if (str.isEmpty()) {
            return new Form(new ArrayList<>(List.of(",", ":")), "0");
        }

        // 기본 구분자
        if (Character.isDigit(str.charAt(0))) {
            return new Form(new ArrayList<>(List.of(",", ":")), str);
        }

        // //;\\n 구분자
        if (str.length() == 5 && str.startsWith("//") && str.charAt(3) == '\\' && str.charAt(4) == 'n') {
            String sep = str.substring(2, 3);
            return new Form(new ArrayList<>(List.of(sep, sep)), "0");
        }

        // 커스텀 구분자
        if (str.length() > 5 && str.startsWith("//") && str.substring(3, 5).equals("\\n")) {
            String sep = str.substring(2, 3);
            return new Form(new ArrayList<>(List.of(sep, sep)), str.substring(5));
        }

        // 조건에 맞지 않는 경우 예외 발생
        throw new IllegalArgumentException();
    }
}
