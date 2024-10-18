package calculator.validator;

import java.util.List;

public class CustomSeparatorValidator {
    public void validate(List<String> customSeparator) {
        if (customSeparator.contains("") || customSeparator.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백은 커스텀 구분자로 사용 불가합니다.");
        } // end if

        if (customSeparator.contains("\\")) {
            throw new IllegalArgumentException("[ERROR] '\\'는 커스텀 구분자로 사용 불가합니다.");
        } // end if

        if (customSeparator.stream()
                .anyMatch(separator -> separator.matches("^[0-9]+$"))) {
            throw new IllegalArgumentException("[ERROR] 숫자는 커스텀 구분자로 사용 불가합니다.");
        } // end if

        if (customSeparator.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 2개 이상일 수 없습니다.");
        } // end if
    } // validate
} // class