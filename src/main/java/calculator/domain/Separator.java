package calculator.domain;

import calculator.validate.SeparatorValidator;
import java.util.ArrayList;
import java.util.List;

public class Separator {

    private final List<String> separatorList;

    public Separator() {
        separatorList = new ArrayList<>();
        separatorList.add(",");
        separatorList.add(";");
    }

    public void addCustomSeparator(String customSeparator) {
        separatorList.add(customSeparator);
    }

    public void validateSeparators(String input) {
        SeparatorValidator validator = new SeparatorValidator();
        validator.validateDefaultSeparators(input, separatorList);
    }

    public String[] splitCalculationString(String expression) {
        String regex = String.join("|", separatorList);
        String[] parts = expression.split(regex, -1);
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }
}
