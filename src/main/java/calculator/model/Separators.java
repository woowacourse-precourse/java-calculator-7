package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public record Separators(
    String separators
) {
    private static final String DEFAULT_DELIMITER = ",:";

    public static Separators parseFrom(String str) {
        if (str.startsWith("//")) {
            String[] split = str.split(Pattern.quote("\\n"));
            String customSeparators = split[0].substring(2);

            return new Separators(DEFAULT_DELIMITER + customSeparators);
        }

        return new Separators(DEFAULT_DELIMITER);
    }

    public String getRegex() {
        String[] sep = separators.split("");
        StringBuilder builder = new StringBuilder("[");

        Arrays.stream(sep)
                .map(Pattern::quote)
                .forEach(builder::append);

        builder.append("]");

        return builder.toString();
    }
}
