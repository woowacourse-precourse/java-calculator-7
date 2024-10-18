package calculator.parser;

import calculator.utils.FormatUtils;

public class PositiveLongParser {

    private static final Long ZERO = 0L;

    public Long parse(String str) {
        if (!FormatUtils.isNumeric(str)) {
            throw new IllegalArgumentException("잘못된 숫자 입력이 있습니다.");
        }
        Long number = Long.parseLong(str);
        if (isNotPositive(number)) {
            throw new IllegalArgumentException("양수만 계산 가능합니다.");
        }
        return number;
    }

    private boolean isNotPositive(Long number) {
        return number.compareTo(ZERO) <= 0;
    }

}
