package calculator.separator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Separators {

    public static final Set<Separator> DEFAULT_SEPARATORS = Set.of(
            new Separator(':'),
            new Separator(','));

    private final Set<Separator> separatorStore;

    public Separators(Set<Separator> separatorStore) {
        this.separatorStore = separatorStore;
    }

    public static Separators empty() {
        return new Separators(new HashSet<>());
    }

    public static Separators withDefault() {
        return new Separators(DEFAULT_SEPARATORS);
    }

    public Separators merge(Separators separators) {
        HashSet<Separator> mergedSeparatorStore = Stream.concat(
                        this.separatorStore.stream(),
                        separators.separatorStore.stream()
                )
                .collect(Collectors.toCollection(HashSet::new));

        return new Separators(mergedSeparatorStore);
    }

    public void add(Separator separator) {
        separatorStore.add(separator);
    }

    public List<String> split(String input) {
        String regex = createRegex();

        return Arrays.stream(input.split(regex))
                .toList();
    }

    private String createRegex() {
        return String.valueOf(separatorStore.stream()
                .map(delimiter -> Pattern.quote(delimiter.toString()))
                .collect(Collectors.joining("|")));
    }
}
