package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {
    public static final int DELIMITER_START_INDEX = 2;
    private final List<Long> sequence;

    public InputSequence(String input) {
        String delimiter = validateCustomDelimiter(input);
        this.sequence = Arrays.stream(input.split(delimiter))
                            .map(Long::parseLong)
                            .toList();
    }

    private String validateCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            for (int i = DELIMITER_START_INDEX; i < input.length(); i++) {
                if (input.startsWith("\\n", i)) {
                    return input.substring(DELIMITER_START_INDEX, i);
                }
            }
        }
        return "[,:]";
    }
}
