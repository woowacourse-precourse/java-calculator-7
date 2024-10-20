package calculator;

import java.util.Arrays;
import java.util.List;

public class DefaultDecimalTokenizer {
    public List<String> split(String value) {
        return Arrays.asList(value.split(","));
    }
}
