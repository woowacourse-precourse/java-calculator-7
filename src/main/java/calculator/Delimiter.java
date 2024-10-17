package calculator;

public class Delimiter {

    private static final String POSITIVE_NUMBER_REGEX = "^(\\+?)\\d*$";
    private static final String CONTAINING_ALL_START_REGEX = "^.*(";
    private static final String CONTAINING_ALL_END_REGEX = ").*";

    private final String delimiter;

    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    private void validateDelimiter(String delimiter) {
        checkIfOnlyLetters(delimiter);
    }

    public void checkIfOtherDelimiterIncluded(StringBuilder existingDelimiterRegex) {
        String totalRegex = CONTAINING_ALL_START_REGEX + existingDelimiterRegex + CONTAINING_ALL_END_REGEX;
        if (delimiter.matches(totalRegex)) {
            throw new IllegalArgumentException("구분자는 다른 구분자를 포함할 수 없습니다.");
        }
    }

    public String escapeMetaCharacter() {
        StringBuilder metaCharacter = new StringBuilder();
        for (char c : delimiter.toCharArray()) {
            if (c == '?' || c == '*' || c == '+' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{'
                    || c == '}') {
                metaCharacter.append("\\").append(c);
            } else {
                metaCharacter.append(c);
            }
        }

        return metaCharacter.toString();
    }

    public StringBuilder addDelimiterToRegex(StringBuilder regex) {
        String escapeMetaCharacter = escapeMetaCharacter();
        return regex.append('|').append(escapeMetaCharacter);
    }

    private void checkIfOnlyLetters(String delimiter) {
        if (delimiter.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("구분자는 숫자로만 이루어질 수 없습니다. 문자를 포함하세요.");
        }
    }

}
