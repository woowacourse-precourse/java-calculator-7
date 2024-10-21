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


}
