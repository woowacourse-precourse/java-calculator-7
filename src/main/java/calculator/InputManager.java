package calculator;

public class InputManager {
    private final String input;
    private String separatorCandidate;
    private String operandCandidates;

    public InputManager(String input) {
        this.input = input;
    }

    public void validate() {
        if(input.matches("[1-9,:]+")) {
            return;
        }
        if(!(input.startsWith("//") && input.contains("\\n"))) {
            throw new IllegalArgumentException("입력 형식이 유효하지 않습니다.");
        }
    }

    public boolean isCustomSeparatorCandidateExisted() {
        return this.input.startsWith("//");
    }

    public String getSeparatorCandidate() {
        if(separatorCandidate == null) {
            int startIndex = input.indexOf("//") + 2;
            int endIndex = input.lastIndexOf("\\n");
            separatorCandidate = input.substring(startIndex, endIndex);
        }
        return this.separatorCandidate;
    }

    public String getOperandCandidates() {
        if (operandCandidates == null) {
            int startIndex = 0;
            if (isCustomSeparatorCandidateExisted()) {
                startIndex = input.lastIndexOf("\\n") + 2;
            }
            operandCandidates = input.substring(startIndex);
        }
        return this.operandCandidates;
    }
}
