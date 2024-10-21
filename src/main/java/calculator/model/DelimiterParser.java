package calculator.model;

import calculator.exception.ErrorMessages;

public class DelimiterParser {

    private static final String DEFAULT_DELIMITERS = ",:"; // 기본 구분자 정의

    public String parseCustomDelimiter(String input) {
        if (!input.startsWith("//")) {
            return null; // 커스텀 구분자가 없으면 null 반환
        }

        int delimiterIndex = input.indexOf("\\n");

        if (delimiterIndex == -1) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_DELIMITER_FORMAT); // 잘못된 구분자 형식
        }

        String customDelimiter = input.substring(2, delimiterIndex); // 구분자 부분 추출

        // 유효성 검사
        if (customDelimiter.isEmpty() || customDelimiter.matches("[0-9\\s]")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_DELIMITER); // 빈 문자열 또는 숫자일 경우
        }

        // 구분자가 두 글자 이상인 경우 체크
        if (customDelimiter.length() > 1) {
            throw new IllegalArgumentException(ErrorMessages.MULTI_CHAR_DELIMITER); // 두 글자 이상일 때
        }

        // 기본 구분자와 동일한 경우 체크
        if (DEFAULT_DELIMITERS.contains(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessages.SAME_AS_DEFAULT_DELIMITER); // 기본 구분자와 동일한 경우
        }

        return customDelimiter; // 커스텀 구분자 반환
    }
}