package calculator;

public class InputManager {
    private final String input;
    private String separatorCandidates;
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
            int startIndex = 0;
            if (isCustomSeparatorCandidateExisted()) {
                startIndex = input.lastIndexOf("\\n") + 2;
            }
            operandCandidates = input.substring(startIndex);
        }
        return this.operandCandidates;
    }
}
