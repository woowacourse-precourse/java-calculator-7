package calculator;

import java.util.regex.Pattern;

/**
 * Delimiters 클래스는 기본 구분자와 커스텀 구분자를 사용하여 문자열을 분리하는 역할을 담당합니다. 다양한 형태의 입력에 대해 기본 및 커스텀 구분자를 처리합니다.
 */
public class Delimiters {

    /**
     * 기본 구분자를 사용하여 숫자를 분리하는 메서드
     *
     * @param input 사용자 입력 문자열
     * @return 분리된 숫자 배열
     */
    public String[] defaultDelimiter(String input) {
        return input.split("[,:]");
    }

    /**
     * 커스텀 구분자를 사용하여 숫자를 분리하는 메서드
     *
     * @param input 사용자 입력 문자열
     * @return 분리된 숫자 배열
     */
    public String[] customDelimiter(String input) {
        int idx = input.indexOf("\\n");
        String customDelimiter = input.substring(2, idx); // 구분자 추출
        String str = input.substring(idx + 2); // \n 이후 부분 추출
        String escapedDelimiter = Pattern.quote(customDelimiter);
        return str.split(escapedDelimiter); // 이스케이프된 구분자로 분리
    }
}
