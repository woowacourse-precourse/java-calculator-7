package calculator.model;
import calculator.validator.InputValid;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private List<String> separators;
    public Separator() {
        separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
    }

    public List<String> getSeparators() {
        return separators;
    }

    public void registerSeparator(String separator) {
        InputValid.checkCustomSeparatorLength(separator);
        separators.add(separator);
    }
}
