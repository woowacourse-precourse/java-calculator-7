package calculator.delimiter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {

    private final Set<Delimiter> delimiters = new HashSet<>(EnumSet.allOf(DefaultDelimiter.class));

    public void add(Delimiter separator) {
        delimiters.add(separator);
    }

    public List<String> separate(String input) {
        String regex = createRegex();
        
        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .toList();
    }

    private String createRegex() {
        return String.valueOf(delimiters.stream()
                .map(delimiter -> Pattern.quote(delimiter.toString()))
                .collect(Collectors.joining("|")));
    }
}
