package calculator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
    // 피연산자 배열
    private List<Integer> operands = new ArrayList<>();

    // 구분자 배열
    private List<Character> separators = new ArrayList<>();

    // 구분자 파싱 중 사용될 임시 배열
    private Stack<Character> buffer = new Stack<>();

    // 기본 구분자 배열에 추가
    public void addBasicSeparators() {
        separators.add(':');
        separators.add(',');
    }

    // 커스텀 구분자 파싱
    public void parsingCustomSeparators(String inputString) {

        for (int i = 0; i < inputString.length(); i++) {

            // 첫 번째 조건
            if (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == '/') {
                buffer.add(inputString.charAt(i + 2)); // 버퍼에 커스텀 구분자 후보 저장

                // 두 번째 조건
                // 백슬래시 2개 해야 백슬래시 1개로 인식됨
                if (inputString.charAt(i + 3) == '\\' && inputString.charAt(i + 4) == 'n') {
                    // 충족 시 구분자 배열에 추가 후 버퍼에서 삭제
                    separators.add(buffer.pop());
                    i += 5; // 커스텀 구분자 조건에 포함되는 부분 skip

                } else {
                    // 버퍼에 저장된 커스텀 구분자 후보 삭제
                    buffer.pop();
                }
            }
        }
    }

    // 구분자 판단
    public boolean isSeparator(Character c) {
        return separators.contains(c) ? true : false;
    }

    // 피연산자 파싱
    public void parsingOperands(String inputString) {
        // 피연산자 파싱 중 사용될 임시 문자열
        String tmpOperand = "";

        for (int i = 0; i < inputString.length(); i++) {
            boolean isSeparator = isSeparator(inputString.charAt(i));

            if (isSeparator) { // 구분자면
                if (!tmpOperand.isEmpty()) { // 문자열이 비어있으면 skip
                    // 지금까지 저장된 문자 숫자로 변환하여 피연산자 배열에 추가
                    operands.add(Integer.parseInt(tmpOperand));
                    tmpOperand = ""; // 문자열 초기화
                }

            } else if (Character.isDigit(inputString.charAt(i))) { // 숫자면
                tmpOperand += inputString.charAt(i); // 임시 문자열에 누적 저장
            }
//            } else { // 구분자도 숫자도 아니면 skip?
//                throw new IllegalArgumentException("등록되지 않은 구분자가 포함되어있습니다.");
//            }
        }

        // 문자열에 숫자가 존재하면 피연산자 배열에 추가
        if (!tmpOperand.isEmpty()) {
            operands.add(Integer.parseInt(tmpOperand));
        }
    }

    // 문자열 파싱 호출 메서드
    public void parseString(String inputString) {
        addBasicSeparators();
        parsingCustomSeparators(inputString);
        parsingOperands(inputString);
    }

    public List<Character> getSeparators() {
        return separators;
    }

    public List<Integer> getOperands() {
        return operands;
    }

}
