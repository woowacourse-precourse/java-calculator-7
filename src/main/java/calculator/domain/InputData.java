package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputData {
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";
    private final List<String> separators;
    private final String firstInputData;

    public InputData(String firstInputData) {
        this.firstInputData = firstInputData;
        separators = new ArrayList<>();
        separators.add(SEPARATOR_COLON);
        separators.add(SEPARATOR_COMMA);
    }
}
