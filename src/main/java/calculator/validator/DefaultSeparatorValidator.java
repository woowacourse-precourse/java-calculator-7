package calculator.validator;

import java.util.Arrays;
import java.util.List;

public class DefaultSeparatorValidator {
    public void validate(List<String> defaultSeparator, String input) {
        if (!Arrays.stream(input.split("")).toList().containsAll(defaultSeparator)) {
            throw new IllegalArgumentException("[ERROR] 기본 구분자는 .과 :만 사용 가능합니다.");
        } // end if
    } // validate
} // class