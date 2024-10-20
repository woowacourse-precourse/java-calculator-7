package separator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SeparatorImpl implements Separator {
    private final Set<String> separators = new HashSet<>();

    public SeparatorImpl() {
        separators.add(",");
        separators.add(":");
    }

    @Override
    public void addSeparator(String separator) {
        if (Objects.nonNull(separator) && !Objects.equals(separator, "")) {
            separators.add(separator);
        }
    }

    @Override
    public Set<String> getAllSeparator() {
        return separators;
    }
}
