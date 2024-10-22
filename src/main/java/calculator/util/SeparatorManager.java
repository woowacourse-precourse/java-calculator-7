package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeparatorManager {
    List<String> separators;

    public SeparatorManager() {
        this.separators = new ArrayList<>(Constants.DEFAULT_SEPARATORS);
    }

    private boolean exists(String separator) {
        return separators.contains(separator);
    }

    public void add(String separator) {
        if (this.exists(separator)) {
            throw new IllegalArgumentException("이미 존재하는 구분자입니다.");
        }
        separators.add(separator);
    }

    public List<String> getSeparators() {
        return Collections.unmodifiableList(separators);
    }
}
