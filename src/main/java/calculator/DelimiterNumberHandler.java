package calculator;

import java.util.Arrays;

public record DelimiterNumberHandler(String delimiters, String numbersString) {

    public void validateStart() {
        InputValidator.validateStart(this.numbersString, this.delimiters);
    }

    private boolean startsWithDelimiter(String input, String delimiters) {
        for (String delimiter : delimiters.split("\\|")) {
            if (input.startsWith(delimiter)) {
                return true;
            }
        }
        return false;
    }

    public String[] splitNumbers() {
        String[] splitNumbers = this.numbersString.split(this.delimiters);
        if (Arrays.stream(splitNumbers).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("연속된 구분자가 입력되었습니다. 올바른 형식으로 다시 입력해 주세요.");
        }
        return splitNumbers;
    }
}
