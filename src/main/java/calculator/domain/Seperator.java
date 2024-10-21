package calculator.domain;

public class Seperator {

    private String seperator;

    public Seperator(String seperator) {
        validateSeperatorIsChar(seperator);
        this.seperator = seperator;
    }

    public void validateSeperatorIsChar(String s) {
        if (s.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 구분자는 한 글자여야 합니다.");
        }
    }
}
