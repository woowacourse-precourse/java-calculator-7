package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {
    private String delimiterPattern;

    public Delimiter() {
        // 기본 구분자로 초기화
        this.delimiterPattern = ",|:";
    }

    public void addCustomDelimiter(String customDelimiter) {
        // 커스텀 구분자를 추가
        this.delimiterPattern += "|" + Pattern.quote(customDelimiter);
    }

    // 문자열을 구분자에 따라 분리하는 메서드
    public String[] split(String input) {
        return input.split(this.delimiterPattern);
    }
}
