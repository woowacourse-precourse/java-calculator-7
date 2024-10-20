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

    public int sum(List<Integer> numberArray) {
        int sum = 0;
        for (Integer number : numberArray) {
            if (number < 0) {
                throw new IllegalArgumentException("[Error] 음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }
}

