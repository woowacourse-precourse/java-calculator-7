package calculator.delimiter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separators {

    public static final Set<Separator> DEFAULT_SEPARATORS = Set.of(
            new Separator(':'),
            new Separator(','));

    private final Set<Separator> separatorStore;

    public Separators(Set<Separator> separatorStore) {
        this.separatorStore = separatorStore;
    }

    public static Separators createCalculatorSeparators() {
        return new Separators(new HashSet<>(DEFAULT_SEPARATORS));
    }

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
