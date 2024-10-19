package calculator;

public class FormulaGenerator {

    private String formula;

    public FormulaGenerator(String input) {

        this.formula = makeFormula(input);
    }

    private String makeFormula(String input) {
        if (input.charAt(0) == '/') {
            InputParser inputParser = new InputParser(input);
            input = inputParser.getParsedInput();
        }
        if (input.isEmpty()) return "0";
        for (int i = 1; i < input.length(); i++) {
            input = changeSeparator(input, i);
        }
        return input;
    }

    private String changeSeparator(String input, int index) {
        if (isSeparate(input.charAt(index))) {
            input = input.replace(input.charAt(index), changeSeparatorToPlusSign());
        }
        return input;
    }

    public String getFormula() {
        return formula;
    }

    private boolean isSeparate(char input) {
        return !Character.isDigit(input);
    }

    private char changeSeparatorToPlusSign() {
        return '+';
    }
}
