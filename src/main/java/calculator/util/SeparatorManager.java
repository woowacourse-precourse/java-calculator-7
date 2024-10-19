package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeparatorManager {
    List<String> separators;

    public SeparatorManager() {
        this.separators = new ArrayList<>(Arrays.asList(",", ":"));
    }

    public boolean exists(String separator) {
        return separators.contains(separator);
    }

    public void add(String separator) {
        separators.add(separator);
    }

    public List<String> getSeparators() {
        return Collections.unmodifiableList(separators);
    }
}
