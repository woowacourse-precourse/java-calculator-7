package calculator.validators;

import static calculator.constant.StandardIndex.FIRST_STANDARD;

public final class DelimiterValidator {

    // "//"의 인덱스 위치는 커스텀 구분자가 있으면 0, 아니면 -1 이여야한다.
    public static void validateDelimiterFormat(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        if (firstIndex > 0) {
            throw new IllegalArgumentException();
        }
    }
}
