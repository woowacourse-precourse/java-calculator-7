package calculator.service;

import java.util.Arrays;
import java.util.List;

public class SplitterService {
    public List<String> split(String input, List<String> separators) {
        String regex = String.join("|", separators);
        return Arrays.asList(input.split(regex));
    }
}
