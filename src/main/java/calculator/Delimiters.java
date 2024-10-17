package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private static final String DEFAULT_DELIMITER_AREA_REGEX = "(:(?=\\d+))|(,(?=\\d+))|(\\/\\/([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)\\\\n)";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private final List<Delimiter> delimiters;
    private StringBuilder areaExcludingDelimiterRegex = new StringBuilder(DEFAULT_DELIMITER_AREA_REGEX);
    private StringBuilder existingDelimiterRegex = new StringBuilder(DEFAULT_DELIMITER_REGEX);

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public void addDelimiter(Delimiter delimiter) {
        delimiter.checkIfOtherDelimiterIncluded(existingDelimiterRegex);

        delimiters.add(delimiter);
        areaExcludingDelimiterRegex = delimiter.addDelimiterToRegex(areaExcludingDelimiterRegex);
        existingDelimiterRegex = delimiter.addDelimiterToRegex(existingDelimiterRegex);
    }

    public StringBuilder getAreaExcludingDelimiterRegex() {
        return areaExcludingDelimiterRegex;
    }

}
