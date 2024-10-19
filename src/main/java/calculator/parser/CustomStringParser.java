package calculator.parser;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CustomStringParser implements StringParser {

    @Override
    public Long[] parseToLong(String input) {
        String[] split = input.substring(2)
                .replaceAll("\\\\n", "\n")
                .split("\\n");

        String delimiter = split[0];
        String numbers = split[1];

        delimiter = Pattern.quote(delimiter);
        String[] splitNumbers = numbers.split(delimiter);
        return Arrays.stream(splitNumbers)
                .mapToLong(Long::parseLong)
                .boxed()
                .toArray(Long[]::new);
    }
}
