package calculator.separator;

import java.util.ArrayList;
import java.util.List;

public class SeparatorRepository {
    private final List<Separator> separators = new ArrayList<>();

    public void save(Separator separator) {
        separators.add(separator);
    }

    public boolean isContainSeparator(Separator separator) {
        return separators.stream().anyMatch(s -> s.separator().equals(separator.separator()));
    }
}
