package calculator;

public class InputParser {
    private String input;
    private String separatorCandidates;
    private String operandCandidates;

    public InputParser(String input) {
        this.input = input;
    }

    public String getSeparatorCandidates() {
        if(separatorCandidates == null) {
            int startIndex = input.indexOf("//") + 2;
            int endIndex = input.lastIndexOf("\\n");
            separatorCandidates = input.substring(startIndex, endIndex);
        }
        return this.separatorCandidates;
    }

    public String getOperandCandidates() {
        if (operandCandidates == null) {
            int startIndex = input.lastIndexOf("\\n") + 2;
            operandCandidates = input.substring(startIndex);
        }
        return this.operandCandidates;
    }
}
