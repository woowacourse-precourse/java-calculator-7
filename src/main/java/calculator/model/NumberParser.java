package calculator.model;

import calculator.exception.ErrorMessages;

public class NumberParser {

    private final String delimiters; // 기본 구분자를 저장하는 문자열

    public NumberParser(String delimiters) {
        this.delimiters = delimiters; // 기본 구분자 초기화
    }

    public String[] parseNumbers(String input, String customDelimiter) {
        // 유효하지 않은 구분자 체크
        String validCharacters = "\\d" + delimiters; // 유효한 문자: 숫자, 설정된 구분자
        // 커스텀 구분자가 있을 경우
        if (customDelimiter != null) {
            validCharacters += customDelimiter; // 유효한 문자에 커스텀 구분자 추가
        }
        // 연속 구분자가 있는지 검사
        boolean wasPreviousDelimiter = false; // 이전 문자가 구분자인지 여부

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                // 현재 문자가 숫자일 경우
                wasPreviousDelimiter = false; // 이전 문자는 구분자가 아님
            } else if (validCharacters.indexOf(c) != -1) {
                // 현재 문자가 구분자일 경우
                if (wasPreviousDelimiter) {
                    throw new IllegalArgumentException(ErrorMessages.MULTIPLE_DELIMITERS); // 연속 구분자 메시지
                }
                wasPreviousDelimiter = true; // 현재 문자가 구분자이므로 다음 문자는 숫자여야 함
            } else {
                // 유효하지 않은 문자가 포함되어 있는 경우
                throw new IllegalArgumentException(ErrorMessages.INVALID_CHARACTER); // 잘못된 구분자 메시지
            }
        }

        // 구분자로 문자열 분리
        return input.split("[" + delimiters + (customDelimiter != null ? customDelimiter : "") + "]"); // 분리된 숫자 반환
    }
}