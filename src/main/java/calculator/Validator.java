package calculator;

import java.util.regex.Pattern;

public class Validator {

    /**
     *  커스텀 구분자 설정을 위한 문자열 형식이 올바른지 판단합니다.
     *
     * @param optionField 사용자가 입력한 커스텀 구분자 설정을 위한 문자열
     * @return 커스텀 구분자 설정을 위한 문자열 형식이 올바르면 true 아니면 false
     */

    public boolean isValidOptionField(String optionField) {
        String customSeparators = optionField.substring(2, optionField.length() - 2);
        String regex = ".*\\d.*";
        return !Pattern.matches(regex, customSeparators);
    }

    /**
     * 추출할 숫자들이 포함된 문자열 형식이 올바른지 판단합니다.
     *
     * @param targetField 사용자가 입력한 추출할 숫자들이 포함된 문자열
     * @param customSeparators 사용자가 입력한 커스텀 구분자
     *
     * @return 추출할 숫자들이 포함된 문자열 형식이 올바르면 true 아니면 false
     */
    public boolean isValidTargetField(String targetField, String customSeparators) {
        // 각 구분자의 이스케이프 문자 처리
        // Pattern.quote()를 사용하여 메타문자를 안전하게 사용하도록 처리
        String escapedSeparators = Pattern.quote(customSeparators);

        // 정규식: 숫자 + ','와 ':'와 커스텀 구분자로 구분된 패턴 (0번 이상 반복 허용)
        String regex = "^\\d+([,:" + escapedSeparators + "]\\d+)*$";

        return Pattern.matches(regex, targetField);
    }

}
