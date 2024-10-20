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

}
