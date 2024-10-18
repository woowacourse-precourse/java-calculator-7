package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Formula {

    private final String formula;
    private final Pattern customPattern = Pattern.compile("^//.\\\\n.*");
    private final Pattern defaultPattern = Pattern.compile("[0-9:,]*");
    private String customDelimiter = "";

    public Formula(String formula) {
        this.formula = validate(formula);
    }

    public String validate(String formula) {
        if (validateDelimiter(formula)) {
            return formula;
        }
        throw new IllegalArgumentException();
    }

    public boolean validateDelimiter(String formula) {
        if (!defaultPattern.matcher(formula).matches() && !customPattern.matcher(formula).matches()) {
            return false;
        }
        customDelimiter = extractCustomDelimiter(formula);
        String customValidationPattern = "^//" + customDelimiter + "\\\\n[0-9:," + customDelimiter + "]*";
        return Pattern.matches(customValidationPattern, formula);
    }

    public String extractCustomDelimiter(String formula) {
        return formula.substring(2, 4);
    }
}
