package utils;

public class AddEntryValidator {

    private static final String ERROR_PREFIX = "Error: ";
    private static final String ADDENTRY_NOT_NUMERIC = ERROR_PREFIX + "계산을 위한 입력값이 숫자가 아닙니다.";

    public void validateNumericEntry(String entry) {
        if (!entry.matches("\\d+")) {
            throw new IllegalArgumentException(ADDENTRY_NOT_NUMERIC);
        }
    }

}
