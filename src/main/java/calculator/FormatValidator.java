package calculator;

import java.util.regex.Pattern;

public class FormatValidator {

    private static final String CUSTOM_FORMAT = "^//[^0-9]\n";
    private static final String NUMBER_FORMAT = "^[0-9,:]*$";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_FORMAT);
    private static final Pattern NUMBER_FORMAT_PATTERN = Pattern.compile(NUMBER_FORMAT);

    /**
     * 주어진 수식(formula)을 유효성 검사하는 메서드입니다.
     * 수식이 숫자로 시작하는지, 또는 '/' 문자로 시작하는지를 확인하여
     * 각각 적절한 형식의 유효성을 검증합니다.
     * 1. 숫자로 시작하면 쉼표(,) 또는 콜론(:) 외의 문자가 포함되었는지 검사합니다.
     * 2. '/' 문자로 시작하면 커스텀 구분자 형식이 맞는지 확인합니다.
     *
     * @param formula 유효성을 검사할 수식 (null 또는 빈 문자열일 수 있음)
     * @throws IllegalArgumentException 잘못된 형식일 경우 예외를 발생시킵니다.
     */
    public void validateFormula(String formula) {
        if (isNullOrEmpty(formula)) {
            return;
        }

        char firstWord = formula.charAt(0);

        if (isNumberStart(firstWord)) {
            validateNumberStartFormat(formula);
        } else if (isCustomStart(firstWord)) {
            validateCustomStartFormat(formula);
        } else {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }
    }

    // 숫자로 시작하는 수식에서 허용되지 않은 문자가 있는지 검증
    private void validateNumberStartFormat(String formula) {
        if (isNotNumberStartFormat(formula)) {
            throw new IllegalArgumentException("수식에는 쉼표 또는 콜론 이외의 문자가 포함될 수 없습니다.");
        }
    }

    private static boolean isNotNumberStartFormat(String formula) {
        return !NUMBER_FORMAT_PATTERN.matcher(formula).matches();
    }

    // 커스텀 구분자 형식을 검증
    private void validateCustomStartFormat(String formula) {
        if (isNotCustomStartFormat(formula)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다. 올바른 형식은 //<숫자가 아닌 문자>\n입니다.");
        }
    }

    private boolean isNotCustomStartFormat(String formula) {
        return formula.length() < 5 || !CUSTOM_PATTERN.matcher(formula.substring(0, 5)).matches();
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isNumberStart(char firstChar) {
        return Character.isDigit(firstChar);
    }

    private boolean isCustomStart(char firstWord) {
        return firstWord == '/';
    }
}
