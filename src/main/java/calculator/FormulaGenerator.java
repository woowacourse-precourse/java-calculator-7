package calculator;

public class formulaGenerator {
    private String input;
    private String formula;

    public formulaGenerator(String input) {
        this.input = input;
        formula = makeFormula(input);
    }

    private String makeFormula(String input) {
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

    private boolean isSeparate(char input){
        return '0'> input || input > '9';
    }

    private char changeSeparatorToPlusSign() {
        return '+';
    }
}
