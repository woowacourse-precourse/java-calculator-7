package calculator.model;

import java.util.Arrays;
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

    public List<Integer> extractNumbers() {
        return Arrays.stream(formula.split("//|\\\\n|:|,|" + customDelimiter))
                .map(this::numberParser)
                .toList();
    }

    public Integer numberParser(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    public Integer calculate() {
        return extractNumbers().stream()
                .reduce(0, Integer::sum);
    }
}
