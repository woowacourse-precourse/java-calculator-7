package calculator.model;

public class Separator {
    private static final String BASIC_SEPARATOR = ",|:";
    private static final String DELIMITER_OF_SEPARATOR = "|\\";

    private static StringBuilder separator;

    public Separator() {
        separator = new StringBuilder();
    }

    public void registerSeparator(String separatorSection) {
        for (int nowSeparatorIdx = 0; nowSeparatorIdx < separatorSection.length(); nowSeparatorIdx++) {
            separator.append(DELIMITER_OF_SEPARATOR);
            separator.append(BASIC_SEPARATOR);
        }
    }

    public String getSeparator() {
        return separator.toString();
    }
}
