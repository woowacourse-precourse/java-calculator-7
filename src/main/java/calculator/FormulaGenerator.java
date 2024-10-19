package calculator;

public class FormulaGenerator {
    private String input;
    private String formula;

    public FormulaGenerator(String input) {
        this.input = input;
        this.formula = makeFormula(this.input);
    }

    private String makeFormula(String input) {
        if(input.isEmpty()) return "0";
        if(input.charAt(0)=='/'){
            InputParser inputParser = new InputParser(input);
            input = inputParser.getparsedInput();
        }
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
