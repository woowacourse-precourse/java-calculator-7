package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SepartorMananger {
    List<String> separators;

    public SepartorMananger() {
        this.separators = new ArrayList<>(Arrays.asList(",", ":"));
    }

    public boolean exists(String separator) {
        return separators.contains(separator);
    }

    public void add(String separator) {
        separators.add(separator);
    }
}
