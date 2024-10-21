package calculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {

    public static List<Integer> parseNumbers(String input, List<String> parser) {
        String[] rawNumbers = input.split(String.valueOf(parser));

        List<Integer> formatNumbers = new ArrayList<>();
        for (String rawNum : rawNumbers) {

            if (rawNum.contains("//")) {
                continue;
            }

            if (rawNum.contains("\\n")) {
                rawNum = rawNum.substring(rawNum.length() - 1);
            }

            formatNumbers.add(Integer.parseInt(rawNum));
        }

        return formatNumbers;
    }
}
