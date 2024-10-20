package calculator;

import static calculator.Constants.*;

public class InputManager {
    private String input;
    private String separatorCandidate;
    private String operandCandidates;

    public InputManager() {
        input = DEFAULT_INPUT;
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
        return separatorCandidate;
    }

    public String getOperandCandidates() {
        if (operandCandidates == null) {
            int startIndex = 0;
            if (isSeparatorCandidateExisted()) {
                startIndex = input.lastIndexOf(CUSTOM_SEPARATOR_POSTFIX) + 2;
            }
            operandCandidates = input.substring(startIndex);
        }
        return operandCandidates;
    }


    public void validate() {
        if (input.matches(VALID_DEFAULT_INPUT_REGEX)) {
            return;
        }
        if (!(input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.contains(CUSTOM_SEPARATOR_POSTFIX))) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
    }

    public boolean isSeparatorCandidateExisted() {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX);
    }
}
