package calculator.delimiter;

import calculator.calculator.Delimiter;
import java.util.Arrays;
import java.util.List;

public class RegularDelimiter implements Delimiter {

    private static final String REST = ",";

    private static final String COLON = ":";

    private static final String REGULAR_DELIMITERS = "[,:]";

    @Override
    public List<String> extractString(String input) {
        return Arrays.stream(input.split(REGULAR_DELIMITERS))
                .toList();
    }

    @Override
    public boolean applicable(String input) {
        return input.contains(REST) || input.contains(COLON);
    }
}
