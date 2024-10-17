package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    private static List<Character> separatorList;

    public Separator() {
        separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(';');
    }

    /*
        커스텀 구분자 지정을 안 한 경우 (기본 구분자 처리)
        - [ ] 구분자들이 기본 구분자로만 구성되어 있는지 확인한다.
     */

    // 기본 구분자 목록 확인
    private boolean isOnlyDefaultSeparators(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) && ch != ',' && ch != ';') {
                return false; // 기본 구분자가 아닌 문자가 발견됨
            }
        }
        return true; // 모든 문자가 기본 구분자임
    }

    // 구분자 검증 메소드 추가
    public void validateSeparators(String input) {
        if (!isOnlyDefaultSeparators(input)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    //구분자가 공백인지 확인한다.
    public void validateCustomEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("커스텀 문자가 공백입니다.");
        }
    }

    //커스텀 구분자의 크기가 최대 길이(2) 범위인지 확인한다.
    public void validateCustomSize(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("커스텀 문자의 최대 길이는 2입니다.");
        }
    }
}
