package calculator;

public class StringChecker {
    private final String inputString;
    private final Delimiters delimiters;

    public StringChecker(String inputString, Delimiters delimiters) {
        this.inputString = inputString;
        this.delimiters = delimiters;
    }

    public Boolean checkEmpty() {
        return inputString.isEmpty();
    }

    public void checkBoundary() {
        if (delimiters.getDelimiters().stream().anyMatch(d -> inputString.startsWith(String.valueOf(d))) ||
                delimiters.getDelimiters().stream().anyMatch(d -> inputString.endsWith(String.valueOf(d)))) {
            throw new IllegalArgumentException("문자열을 잘못 입력하였습니다.");
        }
    }

    public Boolean hasCustomDelimiter() {
        return inputString.startsWith("//");
    }

    public String checkCustomDelimiter() {
        String suffix = inputString.substring(3, 5);
        if (suffix.equals("\\n")) {
            String customDelimiter = inputString.substring(2, 3);
            if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
                throw new IllegalArgumentException("기본 구분자를 커스텀 구분자로 설정할 수 없습니다.");
            }
            return customDelimiter;
        } else {
            throw new IllegalArgumentException("커스텀 구분자를 잘못 입력하였습니다.");
        }
    }

    public String getInputString() {
        return inputString.substring(5);
    }
}
