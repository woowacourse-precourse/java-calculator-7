package calculator.util;

import calculator.constant.MessageConst;

public class SeparatorValidationUtil {

    /**
     * 구분자 문자열이 //로 시작하고 \n으로 끝나는지, 그리고 사이에 정확히 한 개의 문자가 있고, 그 문자가 숫자가 아닌지 검증.
     *
     * @param separatorString 입력 문자열
     */
    public static void validateSeparatorStringFormat(String separatorString) {
        if (!separatorString.startsWith("//") || !separatorString.endsWith("\n")) {
            throw new IllegalArgumentException(MessageConst.INVALID_SEPARATOR_MSG);
        }

        String betweenSeparators = separatorString.substring(2, separatorString.length() - 1);
        if (betweenSeparators.length() != 1 || Character.isDigit(betweenSeparators.charAt(0))) {
            throw new IllegalArgumentException(MessageConst.INVALID_SEPARATOR_MSG);
        }

    }
}
