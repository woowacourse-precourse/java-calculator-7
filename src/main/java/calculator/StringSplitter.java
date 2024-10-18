package calculator;

import java.util.regex.Pattern;

public class StringSplitter {

    private final StringValidator stringvalidator;

    // 의존성 주입을 통해 StringValidator 주입
    public StringSplitter(StringValidator stringValidator) {
        this.stringvalidator = stringValidator;
    }

    // 입력된 문자열을 유효성 검사 후 분리하는 메서드
    public String[] splitString(String input) {
        // 유효성 검사 후 구분자를 반환받음
        String delimiter = stringvalidator.isValid(input);

        // 커스텀 구분자일 경우 숫자 부분만 추출
        if (input.startsWith("//")) {
            int index = input.indexOf("\n");
            input = input.substring(index + 2);  // "\n" 이후의 숫자 부분만 추출
        }

        // 구분자를 이용해 문자열을 분리
        return input.split(Pattern.quote(delimiter));
    }
}
