package calculator.utils;

import calculator.Constants;

/**
 * 구분자와 관련된 유틸리티 클레스
 */
public class SeparatorUtils {

    /**
     * 문자열이 주어지면 PREFIX로 시작하는지 확인
     *
     * @param string PREFIX가 포함된 문자열
     *
     * @return
     * PREFIX가 있으면 true를 반환
     * PREFIX가 없으면 false를 반환
     */
    public static boolean hasSeparator(String string) {
        return string.startsWith(Constants.PREFIX);
    }

    /**
     * 문자열에서 //를 제거한다
     *
     * @param separatorLine //가 포함된 문자열 형태의 구분자
     *
     * @return //가 제거된 문자열 형태의 구분자
     */
    public static String removePrefixAndPostfix(final String separatorLine) {
        return separatorLine.substring(Constants.PREFIX_LENGTH, separatorLine.length() - Constants.POSTFIX_LENGTH);
    }

    /**
     * 문자열 형태의 구분자를 받아 문자로 형태를 바꾼다
     *
     * @throws IllegalArgumentException
     * 구분자는 문자이기 때문에 만일 구분자가 2글자 이상이면 발생
     * 구분자가 0~9 사이의 숫자이면 발생(우테코 기능 요구사항에 기재 안됌)
     *
     * @param separator //를 제외한 문자열 형태의 구분자
     *
     * @return Character 형태로 변환된 구분자
     */
    public static char StringToChar(final String separator) {

        //검증 코드
        if(separator.length() != 1) {
            throw new IllegalArgumentException("구분자가 문자 형식이 아닙니다.");
        }

        char separatorChar = separator.charAt(0);

        //검증 코드
        if(separatorChar > '0' && separatorChar < '9') {
            throw new IllegalArgumentException("구분자가 숫자 입니다");
        }

        return separatorChar;
    }
}
