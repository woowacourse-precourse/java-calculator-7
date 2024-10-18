package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {
    private static final List<String> initDelimiters = Arrays.asList(",", ":");
    private List<String> delimiters = new ArrayList<>();

    public Delimiter(){
        this.delimiters=initDelimiters;
    }

    public void settingDelimiters(List<String> customDelimiters) {
        this.delimiters = customDelimiters;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }
}
