package calculator.validator;

public class DefaultSeparatorValidator {
    public void validate(String input) {
        if (!input.matches("^[0-9,:]+$")) {
            throw new IllegalArgumentException("[ERROR] 기본 구분자는 ,과 :만 사용 가능합니다.");
        } // end if
    } // validate
} // class