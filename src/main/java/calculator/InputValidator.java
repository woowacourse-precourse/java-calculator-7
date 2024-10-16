package calculator;

import java.util.List;

public class InputValidator {

    public void validate(String input) {
        if (isCheckedBlank(input)) {
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
        }

        if (input.startsWith("//")) {
            validateCustomDelimiter(input);
        }
    }

    private boolean isCheckedBlank(String input) {
        return input.isBlank();
    }

    private void validateCustomDelimiter(String input) {
        if (!isCheckedCustomDelimiterFormat(input)) {
            throw new IllegalArgumentException("커스텀 구분자를 사용하기 위한 형식이 아닙니다.");
        }
        if (isCheckedInvalidCustomDelimiter(input)) {
            throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어있습니다.");
        }
    }

    private boolean isCheckedCustomDelimiterFormat(String input) {
        return !input.endsWith("\\n");
    }

    private boolean isCheckedInvalidCustomDelimiter(String input) {
        String customDelimiter = input.substring(2, input.indexOf("\\n"));

        List<String> invalidDelimiters = Delimiter.getInvalidCustomDelimiters();
        for (String invalidDelimiter : invalidDelimiters) {
            if (customDelimiter.contains(invalidDelimiter) || invalidDelimiter.matches(customDelimiter)) {
                return true;
            }
        }

        return false;
    }

}
