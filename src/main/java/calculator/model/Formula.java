package calculator.model;

import calculator.util.Util;
import calculator.validation.Validation;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Formula {

    private final String formula;
    private final Validation validation = new Validation();
    private final String symbolPattern = "//|\\\\n|:|,|";
    private boolean isCustom = false;

    public Formula(String formula) {
        this.formula = validate(formula);
    }

    private String validate(String formula) {
        if (validation.validateCustomDelimiter(formula)) {
            isCustom = true;
            return formula;
        }
        if (validation.validateDefaultDelimiter(formula)) {
            return formula;
        }
        throw new IllegalArgumentException();
    }

    public Integer calculate() {
        return extractNumbers().stream()
                .reduce(0, Integer::sum);
    }

    private List<Integer> extractNumbers() {
        return Arrays.stream(
                        formula.split(symbolPattern + Pattern.quote(getCustomDelimiter()))
                ).map(this::numberParser)
                .toList();
    }

    private String getCustomDelimiter() {
        if (isCustom) {
            return Util.getCustomDelimiter(formula);
        }
        return "";
    }

    private Integer numberParser(String number) {
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
