package calculator.model;

import calculator.util.DelimiterUtils;

// 입력 문자열을 파싱하는 클래스
public class StringParser {

    // 입력 문자열을 파싱하여 숫자 배열을 반환하는 메서드
    public String[] parseInput(String input) {
        return DelimiterUtils.splitInput(input); // DelimiterUtils의 메서드를 호출하여 구분 처리
    }

}