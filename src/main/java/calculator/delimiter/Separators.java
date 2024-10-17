package calculator.delimiter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separators {

    private final Set<Separator> separatorStore = new HashSet<>(
            Set.of(new Separator(':'), new Separator(',')));

    public void add(Separator separator) {
        separatorStore.add(separator);
    }

    public List<String> separate(String input) {
        String regex = createRegex();

        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .toList();
    }

    private String createRegex() {
        return String.valueOf(separatorStore.stream()
                .map(delimiter -> Pattern.quote(delimiter.toString()))
                .collect(Collectors.joining("|")));
    }
}
