package calculator;

public class InputManager {
    private final String input;
    private String separatorCandidates;
    private String operandCandidates;

    public InputManager(String input) {
        this.input = input;
    }

    public boolean validate() {
        if(input.startsWith("//") && input.contains("\\n")) {
            return true;
        }
        return input.matches("[1-9,:]+");
    }

    public boolean isCustomSeparatorCandidateExisted() {
        return this.input.startsWith("//");
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
