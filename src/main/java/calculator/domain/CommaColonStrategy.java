package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class CommaColonStrategy implements DelimiterStrategy {
    @Override
    public List<String> split(String input) {
        return Arrays.asList(input.split("[,:]"));
    }
}
