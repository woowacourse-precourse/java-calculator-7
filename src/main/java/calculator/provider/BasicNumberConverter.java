package calculator.provider;

import java.util.ArrayList;
import java.util.List;

public class BasicNumberConverter {

    private static final List<Character> DELIMITERS = List.of(',', ':');
    private final InputDivider inputDivider;
    private final PositiveLongParser longParser;

    public BasicNumberConverter(String inputString) {
        this.inputDivider = new InputDivider(inputString, DELIMITERS);
        this.longParser = new PositiveLongParser();
    }

    public List<Long> convert() {
        List<String> divided = inputDivider.divide();
        return parseToLong(divided);
    }

    private List<Long> parseToLong(List<String> strings) {
        List<Long> parsed = new ArrayList<>();
        for (String string : strings) {
            parsed.add(longParser.parse(string));
        }
        return parsed;
    }
}
