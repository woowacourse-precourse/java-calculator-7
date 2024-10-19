package calculator.validator;

import java.util.regex.Pattern;

public class ValueValidate implements Validator {

    @Override
    public void validate(String value, String delimiter) {

        if (value.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }

        if (containsInvalidCharacters(value, delimiter)) {
            throw new IllegalArgumentException("잘못된 입력: 구분자와 숫자 이외에 다른 문자가 포함되었습니다.");
        }
    }

    private boolean containsInvalidCharacters(String value, String delimiter) {
        String invalidCharactersRegex = "[^" + Pattern.quote(delimiter) + "\\d]";
        return Pattern.compile(invalidCharactersRegex).matcher(value).find();
    }
}
