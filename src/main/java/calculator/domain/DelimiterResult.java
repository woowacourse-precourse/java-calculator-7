package calculator.domain;

import java.util.Set;

public class DelimiterResult {
    //커스텀 구분자를 제외한 [숫자 + 구분자] 문자열 반환
    public String numberString;

    // 기본 구분자를 포함한 구분자 Set 반환
    public Set<Character> delimiters;

    public DelimiterResult(String numberString, Set<Character> delimiters) {
        this.numberString = numberString;
        this.delimiters = delimiters;
    }

    public String getNumberString() {
        return numberString;
    }

    public Set<Character> getDelimiters() {
        return delimiters;
    }
}
