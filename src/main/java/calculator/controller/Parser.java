package calculator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
    // 피연산자 배열
    private List<Integer> operators = new ArrayList<>();

    // 구분자 배열
    private List<Character> separators = new ArrayList<>();

    // 구분자 파싱 중 사용될 임시 배열
    private Stack<Character> buffer = new Stack<>();

    // 커스텀 구분자 파싱
    public void parsingCustomSeparators(String inputString) {

        for (int i = 0; i < inputString.length(); i++) {

            // 첫 번째 조건
            if (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == '/') {
                buffer.add(inputString.charAt(i + 2)); // 우선 버퍼에 커스텀 구분자 후보 저장

                // 두 번째 조건
                // 백슬래시 2개 해야 백슬래시 1개로 인식됨
                if (inputString.charAt(i + 3) == '\\' && inputString.charAt(i + 4) == 'n') {
                    separators.add(buffer.pop());
                    i += 5; // 커스텀 구분자 조건에 포함되는 부분 skip

                } else {
                    // 버퍼에 저장된 커스텀 구분자 후보 삭제
                    buffer.pop();
                }
            }
        }
    }

    public List<Character> getSeparators() {
        return separators;
    }

    // 기본 구분자 배열에 추가
    public void addBasicSeparators() {
        separators.add(':');
        separators.add(',');
    }

    // 피연산자 파싱


}
