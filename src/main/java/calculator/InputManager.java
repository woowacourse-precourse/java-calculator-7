package calculator;

import static calculator.Constants.*;

public class InputManager {
    private String input;
    private String separatorCandidate;
    private String operandCandidates;

    public InputManager() {
        this.input = DEFAULT_INPUT;
    }

    public void save(String input) {
        this.input = input;
        validate();
    }

    public String getSeparatorCandidate() {
        if (separatorCandidate == null) {
            int startIndex = input.indexOf(CUSTOM_SEPARATOR_PREFIX) + CUSTOM_SEPARATOR_PREFIX.length();
            int endIndex = input.lastIndexOf(CUSTOM_SEPARATOR_POSTFIX);
            separatorCandidate = input.substring(startIndex, endIndex);
        }
        return this.separatorCandidate;
    }

    public String getOperandCandidates() {
        if (operandCandidates == null) {
            int startIndex = 0;
            if (isCustomSeparatorCandidateExisted()) {
                startIndex = input.lastIndexOf(CUSTOM_SEPARATOR_POSTFIX) + 2;
            }
            operandCandidates = input.substring(startIndex);
        }
        return this.operandCandidates;
    }


    public void validate() {
        if (input.matches(VALID_DEFAULT_INPUT_REGEX)) {
            return;
        }
        if (!(input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.contains(CUSTOM_SEPARATOR_POSTFIX))) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
    }

    public boolean isCustomSeparatorCandidateExisted() {
        return this.input.startsWith(CUSTOM_SEPARATOR_PREFIX);
    }
}
