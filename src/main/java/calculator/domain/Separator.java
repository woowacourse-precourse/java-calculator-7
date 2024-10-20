package calculator.domain;

import calculator.constants.SeparatorConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private final List<String> separators = new ArrayList<>(Arrays.asList(
            SeparatorConstants.DEFAULT_COMMA_SEPARATOR,
            SeparatorConstants.DEFAULT_COLON_SEPARATOR));

    public List<String> getSeparators() {
        return separators;
    }

    public void addSeparator(String customSeparator) {
        separators.add(customSeparator);
    }
}
