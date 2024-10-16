package calculator.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColonSemicolonDelimiterHandler {
    public List<Integer> split(String s) {
        String[] splits = s.split("[,:]");

        return Arrays.stream(splits)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

