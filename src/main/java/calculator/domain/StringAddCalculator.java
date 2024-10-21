package calculator.domain;

import calculator.util.CommonConstant;

public class StringAddCalculator {
    private String formula;
    private String delimeter;

    public StringAddCalculator(String formula) {
        this.formula = formula;
        delimeter = CommonConstant.NORMAL_DELIMETER_PATTERN;
    }

    public String getFormula() {
        return formula;
    }

    public String getDelimeter() {
        return delimeter;
    }
}
