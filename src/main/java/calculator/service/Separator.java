package calculator.service;

public class Separator {

    private final String regex;

    private Separator(String regex) {
        validateRegex(regex);
        this.regex = regex;
    }

    public static Separator create(String regex) {
        return new Separator(regex);
    }

    private void validateRegex(String regex) {
        if (regex == null || regex.isEmpty()) {
            throw new IllegalArgumentException("구분자가 존재하지 않습니다.");
        }
        if (regex.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
        }
        if (!SeparatorType.isPermitted(regex)) {
            throw new IllegalArgumentException("허용되지 않는 커스텀 구분자입니다.");
        }
    }

    public String getRegex() {
        return regex;
    }
}
