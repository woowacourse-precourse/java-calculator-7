package calculator.validator;

import calculator.util.ValidatorUtil;

public class DelimiterValidator implements Validator {

    @Override
    public void validate(String value, String customDelimiter) {

        if (customDelimiter == null || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 빈 값일 수 없습니다.");
        }

        if (ValidatorUtil.isContainingNumbers(customDelimiter) || ValidatorUtil.isContainingWhitespace(
                customDelimiter)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 숫자나 공백을 포함할 수 없습니다.");
        }
    }
}
