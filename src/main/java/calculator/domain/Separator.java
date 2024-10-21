package calculator.domain;

public class Separator {

    private String seperator;

    public Separator(String seperator) {
        validateSeparatorIsChar(seperator);
        validateSeparatorIsNotNumber(seperator);
        this.seperator = seperator;
    }

    public void validateSeparatorIsChar(String s) {
        if (s.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 구분자는 한 글자여야 합니다.");
        }
    }

    private void validateSeparatorIsNotNumber(String s) {
        if (Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 숫자는 구분자가 될 수 없습니다.");
        }
    }
}
