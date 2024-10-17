package calculator.delimiter;

import calculator.calculator.Delimiter;
import java.util.Arrays;
import java.util.List;

public class RegularDelimiter implements Delimiter {

    private static final String REST = ",";

    private static final String COLON = ":";

    private static final String REGULAR_DELIMITERS = "[,:]";

    @Override
    public List<String> extractString(String rawInput) {
        return Arrays.stream(rawInput.split(REGULAR_DELIMITERS))
                .toList();
    }

    @Override
    public boolean applicable(String rawInput) {
        return rawInput.contains(REST) || rawInput.contains(COLON);
    }
}
