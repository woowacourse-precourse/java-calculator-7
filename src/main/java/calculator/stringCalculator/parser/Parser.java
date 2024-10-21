package calculator.stringCalculator.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Character> splitters = List.of(',', ':');

    public List<Long> parse(String input) {
        List<Long> result = new ArrayList<>();
        // tryParseUserDefinedSplitter(input);

        StringBuilder builder = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (splitters.contains(character)) {
                result.add(Long.parseLong(builder.toString()));
                builder = new StringBuilder();
                continue;
            }

            builder.append(character);
        }

        if (!builder.isEmpty()) {
            result.add(Long.parseLong(builder.toString()));
        }

        System.out.println(result);

        return result;
    }

//    public void tryParseUserDefinedSplitter(String input) {
//
//    }
}
