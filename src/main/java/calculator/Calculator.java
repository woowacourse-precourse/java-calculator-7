package calculator;

public class Calculator {
    String formula;
    int result;

    public int getResult() {
        return result;
    }

    public Calculator(String formula) {
        this.formula = formula;
        result = calculate(formula);
    }

    private int calculate(String formula) {
        String[] numbers = splitFormula(formula);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number.trim());
        }
        return result;
    }

    private String[] splitFormula(String formula) {
        return formula.split("\\+");
    }

}
