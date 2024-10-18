package calculator.validator;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

public class CustomDelimiterValueValidator implements Validator {

    @Override
    public void validate(String value) {
        if (value.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }

        if (value.matches(".*" + DEFAULT_DELIMITERS + ".*")) {
            throw new IllegalArgumentException("잘못된 입력: 커스텀 구분자 외에 다른 구분자가 포함되어있습니다.");
        }
    }
}
