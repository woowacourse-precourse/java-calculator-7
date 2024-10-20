package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiter {
    private final DelimiterStrategy delimiterStrategy;

    public Delimiter(String input) {
        if (input.startsWith("//")) {
            this.delimiterStrategy = new CustomDelimiterStrategy();
        } else {
            this.delimiterStrategy = new DefaultDelimiterStrategy();
        }
    }

    public String[] getStringNumbersArray(String input) {
        return delimiterStrategy.getStringNumbersArray(input);
    }

    public List<Integer> parse(String[] stringArray) {
        return Arrays.stream(stringArray)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}

