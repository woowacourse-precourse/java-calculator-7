package calculator;

public class FormulaGenerator {
    private String input;
    private String formula;

    public FormulaGenerator(String input) {
        this.input = input;
        if(this.input.charAt(0)=='/'){
            InputParser inputParser = new InputParser(this.input);
            this.input = inputParser.getparsedInput();
        }
        formula = makeFormula(this.input);
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
