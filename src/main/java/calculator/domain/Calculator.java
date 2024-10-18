package calculator.domain;

public class Calculator {

    private final String formula;

    private final String separator;

    public Calculator(String formula, String separator) {
        this.formula = formula;
        this.separator = separator;
    }

    public String getFormula(){
        return this.formula;
    }

    public String getSeparator() {
        return this.separator;
    }
}
