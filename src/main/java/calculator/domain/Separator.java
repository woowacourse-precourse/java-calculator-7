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
            throw new IllegalArgumentException("입력에서 커스텀 구분자 지정이 이루어지지 않았습니다.");
        }
    }
}
