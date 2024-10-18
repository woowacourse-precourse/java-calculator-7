package calculator;

import java.util.List;

public class CustomDelimiterValidator {

    public void validate(String input) {
        if (input.startsWith("//")) {
            if (!isCheckedFormat(input)) {
                throw new IllegalArgumentException("커스텀 구분자를 사용하기 위한 형식이 아닙니다.");
            }

            if (isCheckedInvalidDelimiter(input)) {
                throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어있습니다.");
            }
        }
    }

    private boolean isCheckedFormat(String input) {
        return input.contains("\\n");
    }

    private boolean isCheckedInvalidDelimiter(String input) {
        String customDelimiter = input.substring(2, input.indexOf("\\n"));

        List<String> invalidDelimiters = Delimiter.getInvalidCustomDelimiters();

        for (String invalidDelimiter : invalidDelimiters) {
            if (customDelimiter.matches(invalidDelimiter)) {
                return true;
            }
        }

        return false;
    }

}
