package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    
    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiters createDefault() {
        List<Delimiter> defaultDelimiters = new ArrayList<>();
        defaultDelimiters.add(new Delimiter(","));
        defaultDelimiters.add(new Delimiter(":"));
        return new Delimiters(defaultDelimiters);
    }

    public void add(Delimiter delimiter) {
        delimiters.add(delimiter);
    }
}