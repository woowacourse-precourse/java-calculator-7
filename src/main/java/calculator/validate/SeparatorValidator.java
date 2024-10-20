package calculator.validate;

import java.util.List;

public class SeparatorValidator {

    public void validateDefaultSeparators(String input, List<String> separatorList) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) && !separatorList.contains(String.valueOf(ch))) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }
        }
    }

    public void validateHasSeparators(String input, List<String> separatorList) {
        boolean hasSeparator = false;

        for (String separator : separatorList) {
            if (input.contains(separator)) {
                hasSeparator = true;
                break;
            }
        }

        if (!hasSeparator) {
            throw new IllegalArgumentException("입력에 유효한 구분자가 없습니다.");
        }
    }

    public void validateDuplicateSeparator(String input, List<String> separatorList) {
        if (separatorList.contains(input)) {
            throw new IllegalArgumentException("커스텀 구분자가 중복되었습니다.");
        }
    }
}
