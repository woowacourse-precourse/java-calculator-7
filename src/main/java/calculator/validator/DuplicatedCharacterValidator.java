package calculator.validator;

import java.util.List;

public class DuplicatedCharacterValidator {
    public static void validate(List<String> delimiters) {
        StringBuilder checkedDelimiter = new StringBuilder();
        for (String delimiter : delimiters) {
            if (!checkedDelimiter.toString().contains(delimiter)) {
                checkedDelimiter.append(delimiter);
                continue;
            }
            throw new IllegalArgumentException("중복된 커스텀 구분자가 입력되었습니다.");
        }
    }
}
