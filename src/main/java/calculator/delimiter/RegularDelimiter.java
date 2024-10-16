package calculator.delimiter;

import java.util.Arrays;
import java.util.List;

public class RegularDelimiter implements Delimiter {

    private static final String REST = ",";

    private static final String COLON = ":";

    private static final String REGULAR_DELIMITERS = "[,:]";

    @Override
    public List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(REGULAR_DELIMITERS))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public boolean applicable(String input) {
        return input.contains(REST) || input.contains(COLON);
    }
}
