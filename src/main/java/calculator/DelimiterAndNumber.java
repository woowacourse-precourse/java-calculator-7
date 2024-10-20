package calculator;

import java.util.Arrays;

public record DelimiterAndNumber(String delimiters, String numbersString) {

    public void validateStart() {
        String numbersString = this.numbersString;
        String delimiters = this.delimiters;
        System.out.println(numbersString);
        System.out.println(delimiters);
        if (startsWithDelimiter(numbersString, delimiters)) {
            throw new IllegalArgumentException("입력의 첫 글자가 구분자입니다. 올바른 형식으로 다시 입력해 주세요.");
        }
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
