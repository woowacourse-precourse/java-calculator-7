package calculator.validation;

import java.util.regex.Pattern;

public class Validation {
    private final Pattern customPattern = Pattern.compile("^//([^\\w\\s])\\\\n.*");
    private final Pattern defaultPattern = Pattern.compile("[0-9:,]*");


    public boolean validateDelimiter(String formula) {
        return validateCustomDelimiter(formula) || validateDefaultDelimiter(formula);
    }

    public boolean validateCustomDelimiter(String formula) {
        if (customPattern.matcher(formula).matches()) {
            String formulaFilterPattern = "//|\\d|,|:|\\\\n";
            String filteredFormula = formula.replaceAll(formulaFilterPattern, "");
            return Pattern.matches(Pattern.quote(formula.substring(2, 3)) + "*", filteredFormula);
        }
        return false;
    }

    public boolean validateDefaultDelimiter(String formula) {
        return defaultPattern.matcher(formula).matches();
    }
}
