package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<String> separators;
    private int[] number;
    private int result;

    public Calculator() {
        this.separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
        this.result = 0;
    }

    public List<String> getSeparators() {
        return separators;
    }

    public void addSeparator(String separator) {
        if (!separators.contains(separator)) {
            separators.add(separator);
        }
    }
}
