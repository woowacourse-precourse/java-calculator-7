package calculator.model;

public class DelimiterChecker {

    private static final String DELIMITER_CREATOR_FRONT = "//";
    private static final String DELIMITER_CREATOR_BACK = "\\n";

    public boolean existCustomDelimiter(String value) {
        int frontIndex = value.indexOf(DELIMITER_CREATOR_FRONT);
        int backIndex = value.indexOf(DELIMITER_CREATOR_BACK);

        return frontIndex != -1 && backIndex != -1 && frontIndex < backIndex;
    }
}
