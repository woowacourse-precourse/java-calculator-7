package calculator.validator;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import java.util.regex.Pattern;

public class DefalutDelimiterValueValidator implements Validator {

    @Override
    public void validate(String value) {
        if (value.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }

        if (containsInvalidDefaultDelimiter(value)) {
            throw new IllegalArgumentException("잘못된 입력입니다: 기본 구분자 외의 다른 구분자가 포함되었습니다.");
        }
    }

    private boolean containsInvalidDefaultDelimiter(String input) {
        String invalidDefaultDelimitersRegex = "[^" + DEFAULT_DELIMITERS + "\\d]";

        return Pattern.compile(invalidDefaultDelimitersRegex).matcher(input).find();
    }
}
