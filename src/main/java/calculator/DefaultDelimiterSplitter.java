package calculator;

import java.util.Arrays;
import java.util.List;

public class DefaultDelimiterSplitter {

    private static final String SPLIT_PATTERN = ",";

    public List<String> split(String value) {
        return toList(value.split(SPLIT_PATTERN));
    }

    private List<String> toList(String[] value) {
        return Arrays.asList(value);
    }
}
